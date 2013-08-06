---
layout: page
title:  Content Search Commands
---

**Grep** searches through file text for specific words or character patterns. The following table describes the **grep**, **egrep**, and **fgrep** commands and lists several of their options.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>grep</b></td> <td>Search through files for a specified character
string. By default <b>grep</b> is context sensitive and displays the string in
the context of the line containing the string.

<ul>

<li><b>-A </b><i>number</i><b> </b>prints a specified number of lines
following the matching lines.

</li>

<li><b>-a</b> searches binary (executable) files as though they were text
files.

</li>

<li><b>-B </b><i>number</i><b> </b>prints a specified number of lines before
the matching lines.

</li>

<li><b>-C </b><i>number</i><b>  </b>prints a specified number of lines of
context around the matching lines.

</li>

<li><b>-c </b>shows the number of matches of the string for the file.

</li>

<li><b>-E </b>uses regular expressions for the text pattern.

</li>

<li><b>-e </b><i>pattern</i><b> </b>specifies a literal pattern.

</li>

<li><b>-f </b>searches for multiple strings using a file that lists the string
patterns.

</li>

<li><strong>-F</strong> uses a file as the source for the string patterns.

</li>

<li><b>-i </b>ignores the case of the string.

</li>

<li><b>-l </b>lists just the names of the files with a match. This is used
when search multiple files.

</li>

<li><b>-m </b><i>number</i><b> </b>shows only a specified number of matches
for a file.

</li>

<li><b>-n </b>displays the line number of the lines containing the term.

</li>

<li><b>-r</b> searches the directory and all sub-directories for files
containing the term.

</li>

<li><b>-v</b> displays non-matching lines.

</li>

<li><b>\--include=</b><i>file_name</i><b> </b>searches only in files with
names that match a specified string.

</li>

<li><b>\--exclude=</b><i>file_name </i>searches in files with names that do
<i>not</i> match a specified string.

</li>

<li><b>-w </b>searches for whole words only.

</li>

</ul> </td> <td><b>grep -A 3 Midway ~/docs/WWII-report</b> searches <b>WWII-
report </b>for the pattern <i>Midway</i> and prints the line and the next
three lines.  
<b>grep -a var11 /bin</b> searches all files, including binary files, in the
<b>/bin</b> directory for the pattern <i>var11</i>.  
<b>grep -c 3 Midway ~/docs/WWII-report </b>shows only the number of times the
pattern <i>Midway</i> is found in the <b>WWII-report </b>file.  
<b>grep -e '--count' ~/docs/doc1 </b>looks for the pattern <i>\--count</i> in
the <b>doc1</b> file rather than interpreting it as an option.  
<b>grep -l -r Midway ~/docs </b>shows the name of all files in the
<b>/home/user/docs </b>directory that contain the term <i>Midway</i>.  
<b>grep -m 2 battle ~/docs/WWII-report </b>shows only the first two times the
term <i>battle</i> is found in the file.  
<b>grep -n -i customVariable1 ~/java/program1.java </b>shows the line numbers
of lines that have the term <i>customVariable1</i><b> </b>in the<b>
program1.java</b> file. This is case insensitive.  
<b>grep -r battle ~/docs/ </b>searches the directory and all sub-directories
for the term <i>battle</i>.  
<b>grep -w tank ~/docs/WWII-report </b>searches only for the whole word
<i>tank</i> in the file.</td>

</tr>

<tr> <td><b>egrep</b> </td> <td>Use regular expressions in the search strings.
<b>egrep</b> uses the same options and syntax as <b>grep</b>, and is identical
to <b>grep -E</b>. Constructors for <b>egrep</b> regular expressions include:

<ul>

<li><b>^ </b>matches terms that occur at the beginning of a line.

</li>

<li><b>$</b> matches terms that occur at the end of a line.

</li>

<li><b>\< </b>matches words that begin with the term.

</li>

<li><b>\> </b>matches words that end with the term.

</li>

<li><b>[asdf] </b>matches any one of the characters in the brackets.

</li>

<li><b>[0-9] </b>matches any of the range of numbers 0-9.

</li>

<li><b>[^xyz] </b>omits any one of the letters in the list

</li>

<li><b>. </b>matches any single character.

</li>

<li><b>[asdf]+ </b>matches one or more of the characters in the list.

</li>

<li><b>* </b>matches any number, or none of the preceding single character

</li>

<li><b>|</b> matches either of the terms.

</li>

<li><b>\</b> displays the literal value of a character used for expressions.

</li>

<li><b>()</b> groups expressions.

</li>

</ul></td> <td><b>egrep ^FAILURE ~/error_logs </b>matches the term
<i>FAILURE</i> when it is at the beginning of the line in <b>error_logs</b>.  
<b>egrep tty7$ ~/.bash_history </b>matches the term <i>tty7</i> when it is at
the end of the line.  
<b>egrep \<are ~/myfile </b>matches all words or strings that begin with
<i>are</i>. This includes <i>are</i>, <i>area</i>, and <i>arena</i>.  
<b>egrep \>are ~/myfile </b>matches all words or strings that end with
<i>are</i>. This includes <i>are</i>, <i>hare</i>, and <i>aware</i>.  
<b>egrep watche[ds] ~/myfile</b> matches either <i>watched</i> or
<i>watches</i>.  
<b>egrep exhibit[0-9] ~/myfile </b>matches <i>exhibit1</i>, <i>exhibit3</i>,
or <i>exhibit8</i>.  
<b>egrep [^Xx]mas ~/myfile </b>matches <i>Christmas</i><b> </b>but not
<i>xmas</i> or <i>Xmas</i>.  
<b>egrep .are ~/myfile</b> matches <i>hare</i> and <i>care</i>, but not
<i>aware</i> or <i>are</i>.  
<b>egrep file[0-9]+ ~/myfile</b> matches <i>file0</i>, <i>file10</i>, and
<i>file15636</i>.  
<b>egrep fil* ~/myfile</b> matches <i>fil</i>, <i>filll</i>, and
<i>fillllllllllllllll</i>.  
<b>egrep fil.* ~/myfile </b>matches <i>file</i>, <i>fill</i>, <i>file102</i>,
and <i>filings</i>.  
<b>egrep men|women ~/myfile</b> matches <i>men</i> or <i>women</i>.  
<b>egrep Hello\? ~/myfile</b> matches <i>Hello?</i>.</td>

</tr>

<tr> <td><b>fgrep</b></td> <td>Search for fixed strings, rather than regular
expressions. <b>fgrep</b>:

<ul>

<li>Uses the same options <b>grep</b> uses, and has the same syntax.

</li>

<li>Is identical to <b>grep -F</b>, but searches faster than <b>grep</b>.

</li>

<li> Interprets the pattern as a list of fixed strings, any of which can be
matched.

</li>

</ul> </td> <td>f<b>grep Midway Nimitz ~/docs/myfile</b> searches
<b>myfile</b> for lines containing <i>Midway</i> or <i>Nimitz</i>.  
 </td>

</tr> </table>

