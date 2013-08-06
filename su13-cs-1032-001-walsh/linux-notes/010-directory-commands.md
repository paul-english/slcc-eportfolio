---
layout: page
title:  Directory Commands
---

The following table describes several basic commands when managing
directories:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td><b>pwd</b></td> <td>See the present working directory. </td>
<td>Shells open to the home directory of the current user. For example, if a
user named Fred opened a shell and typed <b>pwd</b> at the prompt,
<b>/home/Fred</b> is displayed.</td>

</tr>

<tr> <td><b>cd</b></td> <td>Change the present working directory.</td>
<td><b>cd directory1</b> changes to a directory named <b>directory1</b> if it
exists in the present working directory. (This is the <i>relative</i> path.)  
<b>cd /home/Fred/directory1</b> opens <b>directory1</b> regardless of the
present working directory. (This is the <i>absolute</i> path.)  
<b>cd ..</b> changes to the parent directory.  
<b>cd /</b> changes to the root directory.</td>

</tr>

<tr> <td><b>ls</b></td> <td>Display the contents of a directory. Options
include:

<ul>

<li><b>-a</b> displays all directory contents, including hidden content.

</li>

<li><b>-l</b> displays a long listing for directory contents, including the
owner, modified date, size, and permissions.

</li>

<li><b>-R</b> displays the contents of the directory and all sub-directories.

</li>

<li><b>-d</b> displays directories but not files.

</li>

<li><b>-r</b> reverses the sort order.

</li>

</ul> </td> <td><b>ls -al</b> displays the long listing of all the contents in
the present working directory.<b>  
ls -d</b> only displays the directories.  
<b>ls -R /etc</b> displays all the contents of the <b>/etc </b>directory and
all sub-directories.</td>

</tr>

<tr> <td><b>mkdir</b></td> <td>Create a new directory. Use the<b> -p</b>
option to create the directories that do not exist.</td> <td><b>mkdir
work_files</b> creates a directory in the present working directory.  
<b>mkdir /home/Fred/work_files</b> creates a directory at the specified
path.</td>

</tr>

<tr> <td><b>cp -r  
cp -R</b></td> <td>Copy directories. Copying leaves the source contents
(directories and files) intact. </td> <td><b>cp -r /temp /home/user</b> copies
the entire <b>/temp</b> directory with all of its files, sub-directories, and
files in the sub-directories to the <b>/home/user </b>directory.</td>

</tr>

<tr> <td><b>mv</b></td> <td>Move or rename directories (and files). Moving
directories erases the source directory and places it in the destination.
Options include:

<ul>

<li><b>-f</b> overwrites directory that already exist in the destination
directory.

</li>

<li><b>-i</b> prompts before overwriting a directory in the destination
directory.

</li>

<li><b>-n</b> never overwrites files in the destination directory.

</li>

</ul> </td> <td><b>mv /temp/station ~/doc/</b> moves <b>station</b> from the
<b>/temp</b> directory to the <b> ~/doc</b> directory.</td>

</tr>

<tr> <td><b>rmdir</b></td> <td>Delete an empty directory.</td> <td><b>rmdir
~/Fred/work_files</b> deletes the <b>work_files</b> directory provided it is
empty.</td>

</tr>

<tr> <td><b>rm</b></td> <td>Remove the directory (and file) inode, but not
actually delete the data. Options include:

<ul>

<li><b>-r</b> deletes directories (and all files) in the directories.

</li>

<li><b>-f</b> deletes without prompting.

</li>

</ul> </td> <td><b>rm -rf /home/user/temp</b> deletes the temp directory with
all its sub-directories and files without prompting.  
<b>rm -r /home/user/*</b> deletes all directories and files in the <b>
/home/user</b> directory.</td>

</tr> </table>

