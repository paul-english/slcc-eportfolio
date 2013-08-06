---
layout: page
title:  File Location Commands
---

Use the following commands to find file locations:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>find</b></td> <td>Search through all files based on the file
system by name, file size, time created, and other options. Be aware of the
following <b>find</b> options:

<ul>

<li><b>-name </b>locates a file or directory by name in a specific path. When
using <b>-name</b>:

<ul>

<li>Enclose name strings in single quotes.

</li>

<li>Use wildcards for partial names.

</li>

<li>Use <b>-iname</b> for case insensitive.

</li>

</ul>

</li>

<li><b>-user</b> finds files owned by a specific user.

</li>

<li><b>-size </b>finds files of a specific size. Use the following options:

<ul>

<li><b>c</b> for bytes

</li>

<li><b>k</b> for kilobytes

</li>

<li><b>M</b> for megabytes.

</li>

</ul>

</li>

<li><b>-mtime </b>finds files last modified before or after a specified number
of days ago.

</li>

<li><b>-type [fd]</b> specifies whether to find files or directories.

</li>

<li><b>-maxdepth</b> specifies how many levels down to search.

</li>

<li>-<b>print0 </b>finds filenames with spaces.

</li>

<li><b>-o</b> specifies the <i>or</i> parameter when searching with multiple
criteria.

</li>

<li><b>.</b> (period) specifies the search locations as the current directory
and subdirectories.

</li>

</ul> </td> <td><b>find /user/home -name '*.txt'</b> finds all plain text
files in the <b>/user/home</b> directory.  
<b>find / -name '*paper*'</b> looks through the entire directory for any
folder or directory name with the term <i>paper</i> in it, such as <b>
termpaper.odt</b> or <b>wallpaper.jpg</b>.<b>  
find /user/home -size -300k</b> finds all files in the <b>/user/home</b>
directory smaller than 300K.  
<b>find /user/home -size +300k</b> finds all files in the <b>/user/home</b>
directory larger than 300K.  
<b>find /user/home -mtime -5</b> finds all files in the <b>/user/home</b>
directory modified within the last five days.  
<b>find / -type f -name '*paper*' </b>finds only files with the string
<i>paper</i> in the name.  
<b>find / -type d -name '*paper*'</b> finds only directories with the string
<i>paper</i> in the name.<b>  
find -maxdepth 3 / -name '*.txt' </b>finds text files three directory levels
down from the root directory.  
<b>find -print0 -name '*.txt'</b> finds myreport.txt and 'my report.txt'.
Without the -print0 option, 'my report.txt' is not listed.</td>

</tr>

<tr> <td><b>locate</b></td> <td>Search an index file for specific parameters.
<b>locate</b>:

<ul>

<li>Is much faster than <b>find</b>.

</li>

<li>Searches <b>/var/log/locatedb</b> as the index file.

</li>

<li>Uses the <b>updatedb</b> command to update the file index.
(<b>/etc/updatedb.conf</b> is the configuration file for <b>updatedb</b>)

</li>

<li>Searches from the root (/) directory if no path is specified.

</li>

<li>Finds all files that contain the specified string without using wildcards.

</li>

<li>Does not by default verify that the file exists if its file index is
outdated.

</li>

<li>Does not display files created after the last time the file index was
updated.

</li>

<li>Does not search for files by attribute.

</li>

</ul>

Be aware of the following <b>locate</b> options:

<ul>

<li><b>-c </b>counts the number of entries rather than list them.

</li>

<li><b>-e </b>lists files only after verifying that they exist.

</li>

<li><b>-i </b>ignores case.

</li>

<li><b>-l </b>limits the number of files listed.

</li>

<li><b>-b </b>searches for the string in only file or directory base names.

</li>

</ul> </td> <td><b>updatedb </b>updates the index file,
<b>/var/log/locatedb</b>.<b>  
locate /user/home paper</b> locates all files with the string <i>paper</i> as
any part of the file name or directory path under the /user/home directory.<b>  
locate lib</b> locates all files with the string <i>lib</i> anywhere in the
file name or directory path.  
<b>locate -c lib </b>counts the number of files with the string <i>lib</i>.
For example <b>46512</b>.  
<b>locate -e .odt </b>verifies that all .odt files listed in the file index
actually exist before it lists them.  
<b>locate -i LibraryFines.csv</b> finds the <b>libraryfines.csv</b> file
regardless of case.  
<b>locate -l 25 lib</b> lists only the first 25 files from the file index that
contain the string <i>lib</i>.<b>  
locate -b lib</b> displays<b> /var/lib</b> and
<b>/user/home/libraryfines.csv</b> but not
<b>/var/lib/usbutils/usb.ids</b></td>

</tr>

<tr> <td><b>which</b></td> <td>Display the path to a command and determine
whether a package is installed.</td> <td><b>which ls</b> shows the path to the
<b>ls</b> binary (executable) file.<b>  
which photorec</b> shows the path to the <b>photorec</b> binary file if
<b>photorec</b> is installed. If the command does not display a path, then the
<b>photorec</b> utility is not installed.</td>

</tr>

<tr> <td><b>whereis</b></td> <td>Display the path to the binary files, the
manual pages, and the source code. Be aware of the following options:

<ul>

<li><b>-b </b>lists the path to the binary file (similar to <b>which</b>).

</li>

<li><b>-m </b>lists the path to the man page files.

</li>

<li><b>-s </b>lists the location of the source code.

</li>

<li><b>-u </b>lists entries that do not have source code, binary file, and man
page locations.

</li>

</ul>

<b>Note</b>: When no options are specified, <b>whereis</b> shows all available
data.

</td> <td><b>whereis -m -u *</b> lists all entries that have no man page
location.</td>

</tr>

<tr> <td><b>type</b> </td> <td>

Display the category of the command. Possible categories include:

<ul>

<li>A built-in shell command

</li>

<li>A command that the shell calls

</li>

<li>An aliased command

</li>

<li>A function

</li>

</ul>

<b>Note</b>: If a called command has been used recently, the output says that
the command is <i>hashed</i>, which means that it is in the shell's hash
table.

</td> <td><b>type cd</b> displays <i>cd is a shell built-in.</i>  
<b>type more</b> displays the path to the binary file for <b>more</b>. </td>

</tr> </table>

**Note**: The term _file globbing _refers to the use of_ _ wildcards (e.g., *****, ***.***, ***.txt**) to match specific files.

