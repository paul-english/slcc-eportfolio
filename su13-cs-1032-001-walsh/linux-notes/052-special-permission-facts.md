---
layout: page
title:  Special Permission Facts
---

Be aware of the following special permissions:

<table>

<tr> <td><b>Permission</b></td> <td><b>Letter Abbreviation</b></td>
<td><b>Example</b></td> <td><b>Octal Value</b></td>
<td><b>Description</b></td>

</tr>

<tr> <td>SUID (Set User ID)</td> <td><b>s</b> in the execute permission
position of the user permissions</td> <td>rw<b>s</b>rw-rw-</td> <td>4</td>
<td>If the SUID bit is set, the program will run with the permissions of the
file owner, not with the permissions of the user who runs the program.

<ul>

<li>The most common use of SUID is to allow users to run a command as the root
user.

</li>

<li>Users do not become the root user, but rather the command or program runs
as if executed by the root user.

</li>

<li>Some programs require the SUID bit set for proper functionality.

</li>

<li>Be careful in setting the SUID bit as it could give a program too many
permissions.

</li>

</ul> </td>

</tr>

<tr> <td>SGID (Set Group ID)</td> <td><b>s</b> in the execute permission
position of the group permissions</td> <td>rwxrw<b>s</b>rw-</td> <td>2</td>
<td>If the SGID bit is set:

<ul>

<li>On a file, the program will run with the group permissions of the group
owner.

</li>

<li>On a directory, a newly-created file will receive the same group owner as
assigned to the parent directory.

</li>

</ul> </td>

</tr>

<tr> <td>Sticky bit </td> <td><b>t</b> in the execute permission position of
the other permissions</td> <td>rwxrw-rw<b>t</b></td> <td>1</td> <td>This marks
the file (not directory) in such a way as to prevent the file's deletion from
the system by anyone except the file owner. Setting the sticky bit works
particularly well with shared files.</td>

</tr> </table>

Use the following commands when managing special permissions:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>ls -l</b></td> <td>View a long file listing. A long file listing
shows the permissions for the files (among other information).</td> <td><b
>drwsr-xr-x</b> 22 root root 4096 Jun 19 15:01 sales (This is a script with
4755 as the permissions; it has the SUID set.)</td>

</tr>

<tr> <td><b>chmod</b></td> <td>Assign a special permission. Be aware of the
following syntax options:

<ul>

<li><b><i>decimal_value </i></b>sets the permissions for the file according to
the numbers represented for each mode category.

<ul>

<li>The special permission <i>precedes </i>the standard octal representation
of a set of permissions

</li>

<li>Only the <i>first </i>number changes to identify the special permission
group settings.

</li>

</ul>

</li>

<li><b><i>category</i>+<i>permission</i></b> adds a special permission for a
user, group, or other (category) to a file.

</li>

<li><b><i>category</i>-<i>permission </i></b>removes a special permission for
a user, group, or other from a file.

</li>

</ul> </td> <td><b>chmod 4421</b> sets the SUID.<b>  
chmod u+s</b> sets the SUID.<b>  
chmod u-s</b> removes the SUID.<b>  
chmod </b><b>2</b><b>421</b> sets the SGID.  
<b>chmod g+s</b> sets the SGID.  
<b>chmod </b><b>1</b><b>421</b> sets the sticky bit.  
<b>chmod u+t</b> sets the sticky bit.  
<b>chmod u-t</b> removes the sticky bit.  
<b>chmod </b><b>6</b><b>421</b> sets both the SUID and SGID.  
<b>chmod </b><b>7</b><b>421</b> sets the SUID, GUID, and stickybit.  </td>

</tr> </table>

