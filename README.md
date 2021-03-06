# jazzler

A tool for creating and interacting with songs using a REPL and textual input.

## Usage

`lein run` to start the REPL, which can be used to evaluate progressions.

## REPL commands

The following commands are available:

help => shows this help screen

help <command> => shows detail info on the command

title <arg?> => shows or sets (if no arg given) the title value 

progression <arg?> => shows or sets (if no arg given) the progression value

tempo <arg?> => shows or sets the tempo value (in bpm)

scale <arg?> => shows or sets the scale (only Major or Minor at the moment)

<Figurename> = <progression> => Defines a Figure, see 'help figure'

structure <figures> => shows or sets the structure of the song

exit, quit => quit the application

## Syntax

The Jazzler language uses roman numerals to represent chords. The numerals indicate the scale degree according to the root note, which is defined by the scale of the song.
At the moment, only triads are supported:

### Major Triads
Major triads are represented by uppercase roman numerals: `I`.
Minor triads are represented by lowercase roman numerals: `i`.
Diminished triads are represented by lowercase roman numerals followed by an 'o': `io`.
Augmented triads are represented by uppercase roman numerals followed by an '+': `i+`.

A song consists of a title and a progression. The title is a string of at least one letter or number.
A progression is a sequence of bars to define the harmonic structure of a song. It is surrounded by `[]` and contains any amount of bars.
A bar consists of at least one chord symbol. To add a bar with only one chord, you can simply write the chord symbol, otherwise you have to surround a bar with `[]`.

`[I]` and `[[I]]` both describe a progression of one bar with the chord of the first scale degree.

### Figures and Structure
In Jazzler you can define figures. Figures are parts of a song, which may be repeated.
The syntax for a figure is as follows:

```
<Figurename> = <Progression>
```

Figurename has to be a string, with the first letter in upper-case and the rest lower-case. For the progression, use the syntax described above.
Example: `Intro = [I ii]`

To set the structure, the syntax is as follows:

```
Structure: <Figurename> (<Figurename>)*
```

The figure names have to be defined before they are used in the structure.

Example: `Structure: Intro Outro`

## Example

```
Song: Demosong
Tempo: 80
Key: Eb Major
Chorus = [I ii [iiio IV+ V] VI [vii I] I]
Outro = [I]
structure Chorus Chorus Outro
```

## Further Information
For more information on Roman Numeral Analysis, see [Wikipedia: Roman Numeral Analysis](https://en.wikipedia.org/wiki/Roman_numeral_analysis).

The project was created for my bachelor thesis, [Entwicklung einer DSL zur Komposition von Jazz-Musik](http://edoc.sub.uni-hamburg.de/haw/frontdoor.php?source_opus=3343&la=de).

## License

Copyright © 2015 Felix Jensen

Distributed under the GNU GENERAL PUBLIC LICENSE Version 3.
