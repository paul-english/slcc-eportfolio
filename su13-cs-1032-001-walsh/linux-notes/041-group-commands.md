---
layout: page
title:  Group Commands
---

Use the following commands to manage group accounts and group membership:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>groupadd</b> </td> <td>Create a new group. The following options
override the settings as found in <b>/etc/login.defs</b>:

<ul>

<li><b>-g</b> defines the group ID (GID).

</li>

<li><b>-p </b>defines the group password.

</li>

<li><b>-r </b>creates a system group.

</li>

</ul> </td> <td><b>groupadd sales</b> creates the <i>sales</i> group.</td>

</tr>

<tr> <td><b>groupmod </b></td> <td>Modify the existing group. Be aware of the
following options:

<ul>

<li><b>-A </b>adds specified users from the group (SUSE distribution)

</li>

<li><b>-R </b>removes specified users from the group (SUSE distribution)

</li>

<li><b>-n </b>changes the name of a group.

</li>

</ul> </td> <td><b>groupmod -R rsem sales</b> removes the <i>rsem</i> account
from the <i>sales</i> group.<b>  
groupmod -n sales2 sales</b> renames the <i>sales</i> group to
<i>sales2</i>.</td>

</tr>

<tr> <td><b>groupdel</b> </td> <td>Delete a group.</td> <td><b>groupdel
mktg</b> deletes the <i>mktg</i> group</td>

</tr>

<tr> <td><b>gpasswd</b> </td> <td>Change a group password.

<ul>

<li><i><b>groupname</b></i> prompts for a new password.

</li>

<li><b>-r</b> removes a group password).

</li>

</ul> </td> <td><b>gpasswd sales</b> prompts for a new group password</td>

</tr>

<tr> <td><b>newgrp</b> </td> <td>Log in to a new group with the group
password.</td> <td><b> newgrp sales</b> prompts for the password for the
<i>sales</i> group before logging in.</td>

</tr>

<tr> <td><b>usermod</b></td> <td>Modify group membership for the user account.
Be aware of the following options:

<ul>

<li><b>-g</b> assigns a user to a primary group.

</li>

<li><b>-G</b> assigns a user to a secondary group (or groups). Follow the
command with a comma-separated list of groups.

</li>

<li><b>-G ""</b> Remove the user from all secondary group memberships. Do not
include a space between the quotes.

</li>

</ul>

<b>Note: </b>When assigning a user to one or more secondary groups, all
existing secondary group memberships are removed before assigning the user
account to new groups.

</td> <td><b>useradd -g pmaxwell pmaxwell</b> assigns primary group membership
for user <i>pmaxwell</i> to the <i>pmaxwell</i> group. <b>  
usermod -G sales,mktg pmorril </b>removes all existing secondary group
assignments for <i>pmorril</i> and makes the user account a member of the
<i>sales</i> and <i>mktg</i> groups.  
<b>usermod -G "" pmaxwell</b> removes the <i><u>pmaxwell</u></i> from all
groups.</td>

</tr>

<tr> <td><b>groups</b></td> <td>Display the primary and secondary group
membership for the specified user account.</td> <td><b>groups pmaxwell</b>
displays group membership for the <i>pmaxwell</i> account.</td>

</tr> </table>

