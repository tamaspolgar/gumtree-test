Hi,

In my solution I'm parsing the lines of the input file one by one. If any of the lines contains an invalid line the processing stops.
It would be possible to change this behaviour to accumulate the parsing errors, with cats.data.ValidatedNel.

I haven't parsed the gender field, I left it as simple String.

There's a small tweak around the birth date parsing, as we have only 2 year digits it's not obvious which year we should use.
In 2 digit year case Java uses a number between 2000 and 2099. In my implementation I'm checking if the parsed date is in the future, in this case I subtract 100 years.

To run the app please execute:
 sbt "runMain gumtree.Task1"
 sbt "runMain gumtree.Task2"
 sbt "runMain gumtree.Task3"

Thanks for reading this,
Tamas