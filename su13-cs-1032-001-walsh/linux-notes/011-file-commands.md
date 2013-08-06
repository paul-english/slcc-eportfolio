---
layout: page
title:  File Commands
---

The following table describes several basic commands when managing files:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td>Examples</td>

</tr>

<tr> <td> <b>touch</b></td> <td>Create a blank file if the file does not
exist, or to update the file's modification and last accessed times if the
file exists.</td> <td><b>touch myfile</b> makes a blank file named
<b>myfile</b>.</td>

</tr>

<tr> <td> <b>cat</b></td> <td>Display the contents of the file in the shell.
This can include displaying multiple files at once.</td> <td><b>cat myfile</b>
displays the contents of the file <b>myfile</b>.  
<b>cat myfile</b> <b>yourfile</b> displays the contents of the file <b>myfile
</b> and <b>yourfile</b> together.</td>

</tr>

<tr> <td> <b>less</b></td> <td>Display the file one screen at a time.

<ul>

<li>Use the SpaceBar<b> </b>to scroll to the next screen.

</li>

<li>Use the Up arrow and Down arrow to scroll up and down.

</li>

<li>Type <b>q</b> to exit.

</li>

</ul> </td> <td> <b>less bigfile</b> displays the contents of <b>bigfile</b>
one screen at a time so it can be read.</td>

</tr>

<tr> <td> <b>head</b></td> <td> List the first 10 lines of a specified file,
by default. The <b>-n</b> option specifies a specific number of lines.</td>
<td> <b>head /home/user/myfile</b> lists the first 10 lines of <b>myfile</b>.  
<b>head -n 20 /home/user/myfile</b> lists the first 20 lines of <b>myfile</b>.  
<b>head -n -35 /home/user/myfile</b> displays all lines in <b>myfile</b>,
omitting the last 35 lines.</td>

</tr>

<tr> <td> <b>tail</b></td> <td>List the last 10 lines of a specified file, by
default. Options include:

<ul>

<li><b>-n</b> specifies a specific number of lines.

</li>

<li><b>-f </b>monitors the file.

</li>

</ul> </td> <td><b>tail /home/user/myfile</b> lists the last 10 lines of
<b>myfile</b>.  
<b>tail -n 20 /home/user/myfile</b> lists the last 20 lines of <b>myfile</b>.  
<b>tail -n -15 /home/user/myfile</b> displays all lines in <b>myfile</b>,
omitting the first 15 lines.</td>

</tr>

<tr> <td><b>file</b></td> <td>Show the file type. The <b>file</b> command
might often be necessary because Linux does not require file extensions.
<b>file</b> uses file signatures in:

<ul>

<li><b>/usr/share/misc/magic</b>

</li>

<li><b>/usr/share/misc/magic.mgc</b>

</li>

<li><b>/etc/magic</b>

</li>

</ul> </td> <td><b>file myfile</b> shows whether <b> myfile</b> is a text,
data, xml or other type of file.</td>

</tr>

<tr> <td><b>cp</b></td> <td>Copy files. Copying leaves the source file intact.
Options include:

<ul>

<li><b>-f</b> overwrites files that already exist in the destination
directory.

</li>

<li><b>-i</b> prompts before overwriting a file in the destination directory.

</li>

</ul> </td> <td><b>cp /temp/document_ab.txt ~/doc/document.txt</b> copies <b>
document_ab.txt</b> from the <b>/temp</b> directory to the <b>~/doc</b>
directory and renames the file to <b>document.txt</b>.  
<b>cp /temp/*.txt ~/doc </b>copies all text files from the <b>/temp</b>
directory to the <b>~/doc</b> directory.</td>

</tr>

<tr> <td><b>mv</b></td> <td>Move or rename files (and directories). Moving
files erases the source file and places it in the destination. Options
include:

<ul>

<li><b>-f</b> overwrites files that already exist in the destination
directory.

</li>

<li><b>-i</b> prompts before overwriting a file in the destination directory.

</li>

<li><b>-n</b> never overwrites files in the destination directory.

</li>

</ul> </td> <td><b>mv /temp/document.txt ~/doc/document.txt</b> moves <b>
document.txt</b> from the <b>/temp</b> directory to the <b> ~/doc</b>
directory.  
<b>mv /temp/*.txt ~/doc/*.txt </b>copies all text files from the <b>/temp</b>
directory to the <b>~/doc</b> directory.</td>

</tr>

<tr> <td><b>rm</b></td> <td>Remove the file (and directory) inode, but not
actually delete the data. The <b>-f </b>option deletes without prompting.</td>
<td><b>rm myfile</b> deletes a file in the current directory named <b>
myfile</b>.  
<b>rm /home/user/myfile</b> deletes <b>myfile</b> from the <b>/home/user</b>
directory regardless of the current directory.  
<b>rm -f /home/user/temp/*</b> deletes all files in the temp directory without
promptings.</td>

</tr>

<tr> <td><b>shred</b></td> <td>Deletes the file and overwrites the file
information. <b>shred</b> is useful when deleting files that contain
proprietary company information or other sensitive data.  Options include:

<ul>

<li><b>-n </b>specifies the times to overwrite. The default is 25 times.

</li>

<li><b>-u</b> deletes the inode.

</li>

<li><b>-v </b>display the progress of the file deletion.

</li>

<li><b>-z </b>overwrites the filename with zeros.

</li>

</ul> </td> <td><b>shred -u -z companysecrets.txt</b> deletes the file <b>
companysecrets.txt</b>, overwrites the file with random information, then
leaves zeros in place of the file.</td>

</tr>

<tr> <td><b>lsattr</b></td> <td>List file attributes.

<ul>

<li><b>-R</b> recursively list attributes of directories and their contents.

</li>

<li><b>-V</b> displays the program version.

</li>

<li><b>-a</b> lists all files in directories.

</li>

<li><b>-d</b> lists directories like other files, rather than listing their
contents.

</li>

<li><b>-v </b>lists the file's version/generation number.

</li>

</ul> </td> <td><b>lsattr /etc/grub/grub.conf</b> lists the attributes of the
<b> grub.conf</b> file.</td>

</tr> </table>

