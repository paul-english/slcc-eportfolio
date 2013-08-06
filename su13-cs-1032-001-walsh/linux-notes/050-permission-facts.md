---
layout: page
title:  Permission Facts
---

Every file has an _inode_ (information node) that stores information about the
file, including when the file was last modified, file size, data block
location, permissions, and ownership (remember, directories are also files in
the Linux system). The portion of the inode that stores permission information
is called the _mode_. The mode has three sections:

  * User (owner) permissions 
  * Group (group owner) permissions 
  * Other (everyone on the Linux system who is not an owner) permissions 

There are three types of permissions contained in the mode, each of which is
described in the table below.

<table>

<tr> <td><b>Permission</b></td> <td><b>Letter Abbreviation</b></td>
<td><b>Octal Value</b></td> <td><b>Allowed Actions on Files</b></td>
<td><b>Allowed Actions on Directories</b></td>

</tr>

<tr> <td>Read </td> <td>r</td> <td>4</td> <td>Open and read the file</td>
<td>List directory contents if the execute permission is also present</td>

</tr>

<tr> <td>Write</td> <td>w</td> <td>2</td> <td>Open, read, and edit the
file</td> <td>Add, delete, and rename files if the execute permission is also
present</td>

</tr>

<tr> <td>Execute </td> <td>x</td> <td>1</td> <td>Execute the file (if it's a
program file) or the shell script</td> <td>Enter the directory and work with
its contents</td>

</tr> </table>

Permissions are identified with either the letter abbreviation (i.e., r, w,
x), or the octal number that corresponds to the permission. The following
graphic shows a detailed depiction of how permissions are displayed and how
they can be referenced.

![](mode.jpg)

Be aware of the following facts about the mode:

  * A **d** preceding the permissions indicates that the object is a directory.
  * A** **dash (-)** **identifies a file (the example above is for a file). 
  * Permissions are grouped according to user, group, or other permissions. 
  * If a permission has not been assigned, a** **dash (-)** **takes its place in order. 
  * When using numbers to represent permissions, add the numbers together within each permission group. Then string the numbers together. For example, the permissions in the graphic above can be represented by the number _764_. 
  * The root user has all permissions to files and directories regardless of the mode settings. 

The table below lists the most common commands for managing permissions:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>ls -l</b></td> <td>View a long file listing. A long file listing
shows the permissions for the files (among other information).</td> <td><b
>drwxr-xr-x</b> 22 root root 4096 Jun 19 15:01 sales (This is a directory with
755 as the permissions)</td>

</tr>

<tr> <td><b>chmod</b></td> <td>Change the permissions for the specified file.
Be aware of the following syntax options:

<ul>

<li><b><i>category</i>+<i>permission</i></b> adds a permission for a user,
group, or other (category) to a file.

</li>

<li><b><i>category</i>-<i>permission </i></b>removes a permission for a user,
group, or other from a file.

</li>

<li><b><i>category</i>=<i>permission</i></b> sets the permission equal to the
permission specified for the user, group, or other for the file.

</li>

<li><b><i>decimal_value </i></b>sets the permissions for the file according to
the numbers represented for each mode category.

</li>

<li><b>-R </b>sets the permission(s) recursively.

</li>

</ul> </td> <td><b>chmod u+x,g+x,o+x myfile</b> adds the execute permission to
the file <i>myfile</i> for user, group, and other.<b>  
chmod g-w,o-w myfile</b> removes the write permission for group and other from
the file <i>myfile</i>.  
<b>chmod u=rwx myfile</b> grants the user read, write, and execute permission
for the file <i>myfile</i>.  
<b>chmod 711 myfile </b>grants the user read, write, and execute permission
(7) while group and other both receive execute permission (1) for the file
<i>myfile</i>.</td>

</tr> </table>

