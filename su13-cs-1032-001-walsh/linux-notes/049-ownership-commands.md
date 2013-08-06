---
layout: page
title:  Ownership Commands
---

When a user creates a file (or directory), the user and the user's primary
group receive ownership for the file (or directory). Only a file owner and the
root user can change file ownership or permissions.

The table below lists the most common commands for managing file ownership.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>ls -l</b></td> <td>View a long file listing. A long file listing
shows the ownership for the files (among other information).</td> <td>drwxr-
xr-x 22 <b>root</b> <b>root</b> 4096 Jun 19 15:01 sales (Root is the file
owner and the group owner for this example)</td>

</tr>

<tr> <td><b>chown</b></td> <td>Change the ownership of a file or directory. Be
aware of the following options:

<ul>

<li><b>-R</b> changes the ownership of the file recursively throughout the
directory tree.

</li>

<li><i><b>user </b></i>changes the file ownership only.

</li>

<li><b><i>user</i>:<i>group</i></b> change the user and group ownership of the
file.

</li>

<li><b>:<i>group</i> </b>changes the group ownership only.

</li>

<li><b><i>.group </i></b>changes the group ownership only.

</li>

</ul> </td> <td><b>chown pmorril /sales/report </b>makes pmorril the user
owner of the /sales/report file.  
<b>chown -R pmorril /sales</b> makes pmorril the owner of all files in the
/sales directory (and below).  
<b>chown pmaxwell:sales /sales/report</b> makes pmaxwell the user owner and
sales the group owner of the file.  
<b>chown :sales -R /sales</b> makes the sales group the owner of all files in
the /sales directory.</td>

</tr>

<tr> <td><b>chgrp</b></td> <td>Change the group owner of a file or
directory.</td> <td><b>chgrp sales /sales/report</b> makes the sales group the
group owner of the file</td>

</tr> </table>

