---
layout: page
title:  File Auditing Facts
---

File auditing involves looking for files that pose a security risk to the
computer, including:

  * Files that have the SUID (Set User ID) permission. With the SUID permission, files will run with the owner permissions, not with the permissions of the user who runs the program. 
  * Files that have the write and execute permissions for _others_ (everyone on the Linux system who is not a user or group owner of the file). If the file is writable by others, anyone can replace the file with a malicious script to create a security risk.

The following table lists several file auditing commands:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>find / type f -perm </b></td> <td>Audit for files that pose a
security risk. Be aware of the following options:

<ul>

<li><b>-o=x </b>audits for the execute permission for others.

</li>

<li><b>-o=w </b>audits for the write permission for others.

</li>

<li><b>-g=x </b>audits for the execute permissions for group owners.

</li>

<li><b>-u=x </b>audits for the execute permission for the owner.

</li>

<li><b>-u=S </b>audits for the SUID bit.

</li>

</ul>

<b>Note</b>: Include the <b>-ls</b> option to display the results with the
long listing.

</td> <td><b>find / type f -perm -o=x -ls  
find / type f -perm -g=x -ls  
find / type f -perm -u=x,o=w -ls</b></td>

</tr>

<tr> <td><b>crontab</b></td> <td>Schedule the auditing task to run on a
regular basis.</td> <td> </td>

</tr> </table>

