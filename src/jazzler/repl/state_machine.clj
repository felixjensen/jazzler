(ns jazzler.repl.state-machine)

(defn state-machine [] 
  {:state :init
   :transition :else})

(defn state [system state]
  (assoc system :state state))

(defn shutting-down? [system]
  (= :shutdown (:state system)))

(defn transition-target [state trans transitions]
  {:pre [(every? #(not (nil? %)) [state trans transitions])]
   :post [(not (nil? %))]}
  (or (trans (state transitions))
      (trans (:all transitions))))

;; TODO: move assoc to the runtime scope
(defn transition [{s :state t :transition :as system} transitions]
  (merge (state system (transition-target s t transitions))
         {:transition :else}))

(defn run 
  ([state-fns transitions]
   (run (state-machine) state-fns transitions))
  ([{state :state :as system} state-fns transitions]
   (when-not (shutting-down? system)
     (-> system 
         ((state state-fns)) 
         (transition transitions)
         (recur state-fns transitions)))))
