---
layout: page
title:  Umask Facts
---

A _umask_ changes (removes) the default file and directory permissions. By
default, files receive rw-rw-rw- (666) permissions, and directories receive
rwxrwxrwx (777) permissions when they are created. In most cases, the default
assignment gives excessive permission to files and directories.

The umask identifies which permissions are _removed_ from the default
permissions when files and directories are created. The following table shows
what happens when the mask is set to a value of 022.

<table>

<tr> <td></td> <td><b>Files  
(binary)</b></td> <td><b>Directories  
(binary)</b></td> <td><b>Files  
(</b>letter abbreviation<b>)</b></td> <td><b>Directories  
(l</b>etter abbreviation<b>)</b></td>

</tr>

<tr> <td><b>Default Permission</b></td> <td>666</td> <td>777</td> <td>rw-rw-
rw-</td> <td>rwxrwxrwx</td>

</tr>

<tr> <td><b>Umask</b></td> <td>022</td> <td>022</td> <td>\----w--w-</td>
<td>\----w--w-</td>

</tr>

<tr> <td><b>Result</b></td> <td>644</td> <td>755</td> <td>rw-r--r--</td> <td
>rwxr-xr-x</td>

</tr> </table>

Additional examples of umask calculations are:

  * A umask of 066 results in file permissions of rw-------- (600) and directory permissions of rwx--x--x (711). 
  * A umask of 033 results in file permissions of rw-r--r-- (644) and directory permissions of rwxr--r-- (744).
  * A umask of 011 results in no changes to file permissions (the x permission is already removed by default) and directory permissions of rwxrw-rw- (766). 

The table below lists the commands for managing the umask:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>umask</b></td> <td>View the current umask setting</td> <td>022 is
the typical umask setting.</td>

</tr>

<tr> <td><b>umask</b> <i>number</i></td> <td>Change the default umask.</td>
<td><b>umask 007</b> sets the umask to remove nothing from the user or group
but to remove all permissions from other.</td>

</tr> </table>

Be aware of the following:

  * The default umask value may vary depending on the Linux distribution (022 or 0022 is typically the default).
  * Setting the umask with the **umask** command is only persistent for the shell session. 
  * To make the umask persistent through shell sessions and reboots, add the **umask** command to the shell configuration** **file (depending on the distribution).

