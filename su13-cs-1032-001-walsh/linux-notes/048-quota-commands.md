---
layout: page
title:  Quota Commands
---

Disk quotas prevent a user or group from using a disproportionate amount of
disk space on a volume. Quota implementations include:

  * Limiting the number of files and directories a user or group can create.
  * Limiting the amount of disk space a user or group can use.

Quota types include the following:

  * A _soft_ limit allows the user to extend the limits of the disk quota. 
  * A _hard_ limit is a fixed limit that the user cannot modify. 

The following table lists the general steps to implement quotas:

<table>

<tr> <td>Step</td> <td>Procedure</td>

</tr>

<tr> <td>Install quota package</td> <td>To install the <b>quota</b> package
(on a System V system):

<ol>

<li>Use <b>rpm -qi quota</b> to see if the package is installed.

</li>

<li>Use <b>yum install </b><i>package</i> to install the quota package if
required.

</li>

</ol> </td>

</tr>

<tr> <td>Edit mount options in <b>/etc/fstab</b></td> <td>Edit the
<b>/etc/fstab</b> file to add the mount options for the filesystem so it can
implement quotas:

<ul>

<li><b>usrquota</b> implements quotas for users.

</li>

<li><b>grpquota</b> implements quotas for groups.

</li>

</ul> </td>

</tr>

<tr> <td>Create quota files</td> <td>Create the <b>aquota.user</b> and
<b>aquota.group</b> files in the directory where the partition is
mounted.</td>

</tr>

<tr> <td>Enable quotas and view a quota report</td> <td>Enable disk quotas,
and then generate a disk usage and quota report. The report shows:

<ul>

<li>How much space to allocate to each user.

</li>

<li>How much space is currently in use by each user.

</li>

<li>Whether some users are using a significant amount of disk space.

</li>

</ul> </td>

</tr>

<tr> <td>Edit quotas</td> <td>Edit a quota for the specified user or group. Be
aware of the following when editing the quotas:

<ul>

<li>Set the soft and hard quotas for <i>blocks</i>. This limits the total
amount of disk space per user or group.

</li>

<li>Set the hard and soft quotas for <i>inodes</i>. This limits the total
number of files and directories per user or group.

</li>

<li>Users may exceed soft quotas for a number of days specified in the
<i>grace</i> period (seven by default.) When the grace period expires, users
cannot create additional files.

</li>

<li>Users cannot exceed hard quotas.

</li>

<li>When setting block quotas, 1000 blocks is about 1 MB, and 1,000,000 blocks
is about 1 GB.

</li>

<li>Setting the quota limits to 0 removes all quotas.

</li>

</ul> </td>

</tr> </table>

The table below describes common commands for working with quotas:

<table>

<tr> <td>Use....</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>quotacheck -mavug</b></td> <td>To create the<b> aquota.user</b>
and<b> aquota.group</b> files in the filesystem (after placing the quota
entries in <b>/etc/fstab</b>). Common options include:

<ul>

<li><b>-m</b> updates the quota database even if other processes are running
on the filesystem.

</li>

<li><b>-a</b> updates the quota database.

</li>

<li><b>-v</b> runs the command in verbose mode.

</li>

<li><b>-u</b> and <b>-g</b> run the database updates for users and groups,
respectively.

</li>

</ul> </td> <td><b>quotacheck -mavug /home </b>creates the <b>aquota.user</b>
and <b>aquota.group</b> files in the root (/) directory.</td>

</tr>

<tr> <td><b>quotaon </b></td> <td>Enable quotas for the mounted filesystem.

<ul>

<li><b>-a</b> enables all mounted filesystems listed in <b>/etc/mtab</b>.

</li>

<li><b>-v</b> runs the command in verbose mode.

</li>

</ul> </td> <td><b>quotaon -av / </b>enables quotas for the root (/)
directory.</td>

</tr>

<tr> <td><b>quotaoff </b></td> <td>Disable quotas for the mounted
filesystem.</td> <td><b>quotaoff /home </b>disables quotas for the<b>
/home</b> directory.</td>

</tr>

<tr> <td><b>repquota</b></td> <td>Display a summary of the disc usage and
quotas for the specified filesystems, including the specific number of files
and used space by user. Common options include:

<ul>

<li><b>-v</b> reports all quotas, even if there is no usage.

</li>

<li><b>-n </b>does not resolve user and group names to speed printing time .

</li>

<li><b>-u</b> and <b>-g</b> reports for users and groups, respectively.

</li>

<li><b>-a</b> gives information for all filesystems listed in
<b>/etc/mtab</b>.

</li>

</ul> </td> <td><b>repquota /home -uv </b>creates a user quota report for
the<b> /home</b> directory.</td>

</tr>

<tr> <td><b>edquota </b></td> <td>Open and edit a user's quota, a groups
quota, or change the grace period:

<ul>

<li><b>-u</b> changes the users quota

</li>

<li><b>-g</b> changes a groups quota

</li>

<li><b>-t</b> changes the grace period

</li>

</ul> </td> <td><b>edquota -u</b> <b>mtomm </b>opens the quota file for the
<i>mtomm</i> user account.</td>

</tr>

<tr> <td><b>quota</b></td> <td>Display the current user's quota:

<ul>

<li><b>-u</b> shows the quota for a user.

</li>

<li><b>-g</b> shows the quota for a group

</li>

<li><b>-v</b> shows current the current usage, the hard quota and the soft
quota for blocks and inodes.

</li>

</ul> </td> <td><b>quota </b>displays the quota report only for the current
user account.<b>  
quota -u dhanson </b>displays the quota report only for the <i>dhanson</i>
user account.</td>

</tr> </table>

