---
layout: page
title:  Link Facts
---

Links are files that point to another file. When links are accessed, they
reference the source file's inode_._ The _inode _specifies where a file's data
physically exists on a disk. Link types include:

<table>

<tr> <td>Type </td> <td>Description</td>

</tr>

<tr> <td>Hard link</td> <td>A <i>hard link</i> is a duplicate entry in the
file system that points to a specific piece of data on the disk drive. A hard
link:

<ul>

<li>Creates a duplicate file inode.

</li>

<li>Is indistinguishable from the original files.

</li>

<li>Maintains a valid inode for the file data even if the original file is
deleted.

</li>

<li>Has a dash (-) as the first character in the permission string (which is
the same for original files). For example, <b>-</b>rwxr-xr-x.

</li>

</ul></td>

</tr>

<tr> <td>Symbolic link</td> <td>A <i>symbolic link</i> (also known as a
<i>soft link</i>) is a file system entry that points to another file system
entry, which in turn points to a valid piece of data. A symbolic link:

<ul>

<li>Has a distinct inode.

</li>

<li>Can work across volumes and file systems.

</li>

<li>Is similar to shortcuts in the Windows OS.

</li>

<li>Has a lower-case L (l) as the first character in the permission string.
For example, <b>l</b>rwxrwxrwx indicates a symbolic link.

</li>

</ul></td>

</tr> </table>

The table below describes the commands for creating hard links and symbolic
links:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>ln </b><i>source link_name</i></td> <td>Create links.

<ul>

<li><b>ln -s</b> creates a symbolic link to a file.

</li>

<li><b>ln -b</b> creates backup of a file.

</li>

<li><b>ln -i </b>determines the inode for hard or symbolic links.

</li>

<li><b>ln </b>(with no options) creates a hard link between files.

</li>

</ul> </td> <td><b>ln /home/jsmith/project1 /home/edunford/project1</b>
creates an exact copy of <b>/home/jsmith/project1</b> in
<b>/home/edunford/</b>.<b>  
ln -s /home/jsmith/project1 /home/edunford/project1_ln</b> creates a pointer
named <b>/home/edunford/project1_ln</b> that points to
<b>/home/jsmith/project1</b>.  
<b>ln -s /home/jsmith/project1 /home/edunford/project1_ln</b> creates a
pointer named <b>/home/edunford/project1_ln</b> that points to
<b>/home/jsmith/project1</b>.  
<b>ln -i</b> displays the inodes for the contents in the present working
directory.  
<b>ln -b /home/jsmith/file1 /bup </b>copies <b>file1 </b>as <b>file1~ </b>in
<b>/bup</b>.</td>

</tr>

<tr> <td><b>cp </b><i>source link_name</i></td> <td>Copy files and create
links.

<ul>

<li><b>cp -l</b> creates hard links rather than copying the files.

</li>

<li><b>cp -s</b> creates symbolic links rather than copying the files.

</li>

</ul> </td> <td><b>cp -l /home/jed/fil1 /home/esam/proj1</b> creates an exact
copy of <b>/home/jed/fil1</b> in <b>/home/esam/</b>.<b>  
cp -s /home/mkon/text /home/ytew/text_ln</b> creates a symbolic link named
<b>/home/ytew/text_ln</b> that points to <b>/home/mkon/text</b>.</td>

</tr> </table>

