A simple name generator I built for enjoyment and to practice with Data Access Objects and database connectivity in Java prior to some assignments in university.

Has the ability to create fictional names from syllables and real world names from the included database.

Run from root directory with:
```bash
java -cp ".:lib/sqlite-jdbc-3.23.1.jar:bin/" NameGenerator
```

***

Feature improvements to be made:
* Extend list of syllables and move to database tables.
* Investigate if randomising and limiting query results is faster in SQLite instead of Java.
* Diversify syllables into categories to allow for fantasy-based generation (Elf/Orc/Dwarf/etc.).
* Incorporate into a JavaFX application to provide a GUI.