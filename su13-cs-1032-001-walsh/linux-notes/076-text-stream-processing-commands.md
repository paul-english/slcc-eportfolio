---
layout: page
title:  Text Stream Processing Commands
---

A_ text stream_ is any information printed to standard output (usually the
screen). For example, the **ls** command sends the list of files to the
screen. The following commands intercept and process the text stream in
various manners:

<table>

<tr> <td>Use...</td> <td>To...</td> <td><b>Example</b></td>

</tr>

<tr> <td><b>cut</b></td> <td>Remove characters and fields from lines of text
in a text stream or file. The command uses its options to determine whether to
cut characters or fields and sends the results to standard output. Be aware of
the following options:

<ul>

<li><b>-c</b> cuts characters.

</li>

<li><b>-f</b> cuts fields.

</li>

<li><b>-d</b> specifies the character used as the field delimiter. The default
is a tab.

</li>

<li><b>-s</b> removes lines that do not have a field delimiter.

</li>

<li> <b>-d' '</b> to specify a space as the field delimiter.

</li>

</ul> </td> <td>For the following example, a file named <i>myfile</i> has the
following text:

http://www.site1.com  
http://www.mysite.com  
http://www.anothersite.com

<b>cut -c1-7 myfile</b> takes the first seven characters of each line and
sends it to standard output. For the example, this is <i>http://</i>.  
<b>cut -c8- myfile</b> takes character eight to the end of each line and sends
it to standard output. This removes <i>http://</i> from each line.

</td>

</tr>

<tr> <td><b>expand</b></td> <td>Replace a tab character with a specified
number of spaces.

<ul>

<li>The default is eight spaces.

</li>

<li><b>-t </b>specifies the number of spaces to be used.

</li>

</ul> </td> <td><b>expand -t 1 myfile</b> replaces each tab character in the
file with a single space.</td>

</tr>

<tr> <td><b>fmt</b></td> <td>Format lines in a file or text stream to a
uniform length. This is useful to format files with long lines to fit in a
terminal. Be aware of the following options:

<ul>

<li><b>-w</b> specifies the number of characters for the width. The default is
75.

</li>

<li><b>-s</b> prevents the command from formatting lines shorter than the
specified length. This command is often used with code text to keep lines of
code separate.

</li>

</ul> </td> <td><b>fmt -w 80 myfile</b> sends the contents of <i>myfile</i> to
standard output with all lines having a uniform length of 80 characters. </td>

</tr>

<tr> <td><b>join</b></td> <td>Combine text from two files based on identical
fields with text and send the result to standard output. By default, fields
are offset by whitespace. Be aware of the following options:

<ul>

<li><b>-i</b> ignores case when searching for identical text.

</li>

<li><b>-j</b> specifies the number of the field to use when joining. This
specifies both files.

</li>

<li><b>-1</b> specifies the number of the field from the first listed file to
use when joining.

</li>

<li><b>-2</b> specifies the number of the field from the second listed file to
use when joining.

</li>

<li><b>-t </b>specifies the character to use as the field delimiter.

</li>

</ul> </td> <td>File1 has the following text:

1 Mark Twain  
2 William Shakespeare  
3 John Steinbeck

File2 has the following text:

1 Tom Sawyer  
2 Othello  
3 Of Mice and Men

<b>join file1 file2</b> sends the following text to standard output:

1 Mark Twain Tom Sawyer  
2 William Shakespeare Othello  
3 John Steinbeck Of Mice and Men

<b>join -j 3 -t : fileA fileB</b> joins the files using the third field as the
common field, and a colon as the field delimiter.

</td>

</tr>

<tr> <td><b>nl</b></td> <td>Place a line number in front of each line in a
text file and send the result to standard output. Be aware of the following
options:

<ul>

<li><b>-i </b>specifies the increment to use when numbering the lines.

</li>

<li><b>-v </b>specifies the starting number.

</li>

<li><b>-s</b> specifies the text to place between the number and the line. The
default is two spaces.

</li>

</ul> </td> <td><b>nl -s ": " myfile</b> adds the number, a colon, and a space
to the front of each line in the file.</td>

</tr>

<tr> <td><b>od</b></td> <td>Display the contents of any file in octal,
decimal, hexadecimal, or character format. Be aware of the following options:

<ul>

<li><b>-b</b> specifies an octal dump.

</li>

<li><b>-d</b> specifies a decimal dump.

</li>

<li><b>-x</b> specifies a hexadecimal dump.

</li>

<li><b>-c</b> specifies a character dump.

</li>

</ul></td> <td><b>od -c /bin/tar</b> shows the contents of the tar command
executable in character format.</td>

</tr>

<tr> <td><b>paste</b></td> <td>Add the contents of one file to the contents of
another file on a line-by-line basis.

<ul>

<li>The default is a tab.

</li>

<li><b>-d</b> specifies a character to place between the conjoined lines of
each file. Only a single character can be specified.

</li>

</ul> </td> <td><b>paste -d @ file1 file2 </b>conjoins each line of
<i>file2</i> to the end of each line of <i>file1</i> and places an <i>@</i>
between each line pair.



</td>

</tr>

<tr> <td><b>pr</b></td> <td>Format a text file for printing. By default this
command:

<ul>

<li>Separates files into 66-line pages.

</li>

<li>Uses the first five lines to create a header that contains a page number,
the time and date, and the path to the file.

</li>

<li>Uses the last five lines to create a footer of blank lines.

</li>

</ul>

Be aware of the following options:

<ul>

<li><b>-d </b>double-spaces the lines.

</li>

<li><b>-h</b> specifies text to replace the file name in the header.

</li>

<li><b>-l </b>specifies the number of lines. The default is 66.

</li>

<li><b>-t</b> prevents the command from creating the header and footer.

</li>

<li><b>-o </b>creates a margin on the left side of the text.

</li>

</ul> </td> <td><b>pr myfile</b> sends the text to standard output using
default settings.  
<b>pr -d -l 60 -t -o 5 myfile </b>sends the text to standard output using,
double spacing, a page length of 60 lines, no headers or footers, and a
5-space margin on the left side.</td>

</tr>

<tr> <td><b>sed</b></td> <td>Take text or commands from the command line as
input and modifies the text document named in the command line. <b>sed</b> is
particularly useful under the following circumstances:

<ul>

<li>When a file is too large to open and edit conveniently in a text editor.

</li>

<li>When the series of edits (e.g., adding line spacing, margins, replacing
text) is too complex to perform easily in a text editor.

</li>

<li>When it is easier to perform a series of global document changes.

</li>

</ul>

Be aware of the following flags and options:

<ul>

<li><b>s </b>replaces the text behind the first <b>/</b> with the text behind
the second <b>/</b>. To save the results of the command, use the <b>></b> to
redirect the output to a new file.

</li>

<li><b>d</b> deletes lines that contain the specified term.

</li>

<li><b>g</b> changes all occurrences of the term in a line.

</li>

<li><b>p</b> prints the modified lines in addition to the standard output.

</li>

<li><b>-n </b>suppresses all printing. The <b>p</b> flag can be used to print
the modified lines.

</li>

<li><b>-e</b> allows multiple commands in a sed operation.

</li>

<li><b>-f</b> calls a file filled with editing commands (one command per line)
to perform a number of operations at one time instead of doing them
individually from the command line.

</li>

</ul> </td> <td><b>sed 's/Nancy/Nanci' <i>originalfilename</i>
><i>newfilename</i></b> replaces every occurrence of "Nancy" with "Nanci."  
<b>sed -n '/there were no credible/,/transfer assets abroad/p'
<i>filename</i></b> displays only the text of a paragraph beginning with
"there were no credible" and ending with "transfer assets abroad."<b>  
sed -n 56,89p <i>filename</i></b> displays lines 56 through 89 of the
specified file.  
<b>sed -e 's/J.K.W/James K. Whitworth, Esq./' -e 's/Hillary Stuart/Ms. Mary
Edwards' -e s/Johnson, Gabriel, and Hawkins/McPhee, Larkin, Simmons'
<i>originalfilename</i> ><i>newfilename</i></b> allows three substitution
commands to occur at the same time.<b>  
sed -f <i>scriptfilename</i> <i>originalfilename</i> ><i>newfilename</i></b>
treats the <i>scriptfilename</i> file as a script file, running each command
against the text in the original file and saving the results to the new file.  
<b>echo night day night | sed s/night/day/g</b> changes both instances of the
term <i>night</i> to <i>day</i>. Without the trailing <i>g</i> flag, only the
first instance changes.</td>

</tr>

<tr> <td><b>awk</b></td> <td>Create reports based on the data you retrieve
from files, build databases, or perform mathematical operations against
numbers in text files.

Be aware of the following patterns and actions:

<ul>

<li><b>-f</b> specifies a file containing <b>awk</b> commands to be used.

</li>

<li><b>-F</b> specifies the field delimiter to be used. The default is
whitespace.

</li>

<li><b>$</b><i>#</i> is used to designate fields. For example, <i>$6</i> is
the sixth field in a line.

</li>

<li><b>\t </b>inserts a tab.

</li>

<li><b>\n</b> inserts a newline character

</li>

<li><b>\f</b> inserts a form-feed character

</li>

<li><b>\r</b> inserts a carriage return.

</li>

</ul></td> <td> <b>awk -F: '{print $1}' /etc/passwd | sort </b>prints a sorted
list of the user names in <b>/etc/passwd</b>.  
<b>ls -l | awk '{print "File name: "$9"\tOwner: "$3"\tModified date and time:
"$6"\t"$7"\t"$8}' </b>customizes the <b>ls -l</b> command. From the long
listing, it rearranges the ninth field to come first, labels each printed
field, omits unwanted fields, and adds a tab between fields.</td>

</tr>

<tr> <td><b>sort</b></td> <td>Sort each line of text in a file or from a text
stream alphabetically. Be aware of the following options:

<ul>

<li><b>-b</b> ignores leading blank spaces.

</li>

<li><b>-d</b> uses the first alpha-numeric character and ignores special
characters.

</li>

<li><b>-f</b> ignores case.

</li>

<li><b>-M</b> sorts by month.

</li>

<li><b>-n</b> sorts according to the string numeric value.

</li>

<li><b>-r</b> reverses the sort order.

</li>

</ul> </td> <td><b>ls | sort -r</b> reverses the sort order of files from the
<b>ls</b> command.  
<b>sort -b -d -f myfile</b> sorts each line in <i>myfile</i> and it ignores
leading spaces, character case, and special characters.</td>

</tr>

<tr> <td><b>split</b></td> <td>Split lines of text from a file or a text
stream into segments of a specified number of lines. Be aware of the following
options:

<ul>

<li><b>-l, -<i>number</i></b> specifies the number of lines per file.

</li>

<li><b>-b</b> splits text into a specified byte size instead of number of
lines.

</li>

<li><b>-d </b>uses numeric suffixes rather than alphabetic.

</li>

<li><b>-a</b> specifies the number of characters in the suffix.

</li>

</ul> </td> <td><b>split -50 -d -a 3 AllNames FiftyNames-</b> splits the
<i>AllNames</i> file into individual files containing 50 lines each from the
content of the <i>AllNames</i> file. The output is <i>FiftyNames-001</i>,
<i>FiftyNames-002</i>, and so on.</td>

</tr>

<tr> <td><b>tr</b></td> <td>Transpose characters in a text stream. <b>tr
</b>only works with character streams. The command uses two character sets.

<ul>

<li>The first set specifies the characters to be changed.

</li>

<li>The second set specifies what they should be changed to.

</li>

</ul>

Be aware of the following options:

<ul>

<li><b>-c</b> changes all characters except those specified in the first set.

</li>

<li><b>-d</b> deletes characters found in the first set.

</li>

<li><b>-s</b> changes double-characters to single ones.

</li>

<li><b>-t</b> truncates the first set of characters to match the size of the
second set.

</li>

</ul> </td> <td><b>cat myfile | tr a A</b> changes every lower-case a to an
upper-case A in the output from <i>myfile</i>.  
<b>cat myfile | tr abc lmn</b> changes each <i>a</i> to an <i>l</i>, each <i>
b</i> to an <i>m</i>, and each <i>c</i> to an <i>n</i> in the output from <i>
myfile.</i>  
<b>cat myfile | tr -d asdf</b> deletes each <i>a</i>,<i> s</i>,<i> d</i>, and
<i>ff</i> from the output of <i>myfile</i>.  
<b>cat myfile | tr -c e f</b> changes every character in the output from my
file to an <i>f</i> except for the letter <i>e</i>.  
<b>cat myfile | tr -s t</b> changes double <i>tt</i> to a single <i>t</i>.  
<b>cat myfile | tr -t abcde lmn</b> ignores the <i>dd</i> and the <i>e</i> in
the first set and only changes <i>a</i>, <i>b</i>, and <i>c</i>. Without the
<i>-t</i> option, every <i>c</i>, <i>d</i>, and <i>e</i>, is changed to an
<i>n</i>.

<b>Note:</b> Use <i>a-m</i> to specify all characters <i>a</i> through
<i>m</i>

</td>

</tr>

<tr> <td><b>unexpand</b></td> <td>Change spaces into a tab. Be aware of the
following options:

<ul>

<li><b>-a</b> specifies that the command change all occurrences. Without
<b>-a</b>, the command only changes leading spaces.

</li>

<li><b>-t</b> specifies the number of spaces to be changed. The default is
eight.

</li>

</ul> </td> <td><b>unexpand -a -t 3,4,5 myfile</b> changes each occurrence of
three, four, or five consecutive spaces into a tab using text from
<i>myfile</i>. </td>

</tr>

<tr> <td><b>uniq</b></td> <td>Filter identical lines from a file. The lines
must be adjacent. Be aware of the following options:

<ul>

<li><b>-d</b> prints only the duplicate lines

</li>

<li><b>-f</b> specifies the number of initial words to skip. Words are
delimited by white space.

</li>

<li><b>-s</b> specifies the number of initial characters to skip.

</li>

<li><b>-w</b> specifies the number of characters to compare in each line.

</li>

<li><b>-u</b> leaves out the duplicate lines

</li>

</ul> </td> <td><b>uniq myfile</b> omits all repeated lines in <i>myfile</i>.
It prints the first occurrence only.  
<b>uniq -d myfile</b> prints only the repeated lines.  
<b>uniq -u myfile </b>prints only the unique lines.  
<b>uniq -f 4 myfile</b> skips the first four words when comparing lines.  
<b>uniq -s 4 myfile</b> skips the first four characters when comparing lines.  
<b>uniq -w 4 myfile</b> uses only the first four characters when comparing
lines.</td>

</tr>

<tr> <td><b>wc</b></td> <td>Print the number of bytes, characters, lines, or
words, or the length of the longest line from the text of a file or text
stream. Be aware of the following options:

<ul>

<li><b>-c</b> specifies bytes.

</li>

<li><b>-m</b> specifies characters. Character count is often identical to byte
count.

</li>

<li><b>-l </b>specifies line count.

</li>

<li><b>-L</b> specifies length of the longest line.

</li>

<li><b>-w</b> specifies word count.

</li>

</ul>

<b>Note:</b> When no options are used, the command prints line count, word
count, and byte count respectively.

</td> <td><b>wc myfile</b> displays line, word and character count.  
<b>wc -L myfile</b> displays the length of the longest line in the file.  
<b>wc -m myfile</b> displays the number of characters in the file.</td>

</tr> </table>

