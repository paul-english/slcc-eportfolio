---
layout: page
title:  User Commands And Files
---

Be aware of the following configuration files when managing user accounts:

<table>

<tr> <td><b>File</b></td> <td><b>Description</b></td>

</tr>

<tr> <td><b>/etc/default/useradd</b></td> <td>The <b>/etc/default/useradd</b>
file contains default values used by the <b>useradd</b> utility when creating
a user account, including:

<ul>

<li>Group ID

</li>

<li>Home directory

</li>

<li>Account expiration

</li>

<li>Default shell

</li>

<li>Secondary group membership

</li>

</ul></td>

</tr>

<tr> <td><b>/etc/login.defs</b></td> <td>The <b>/etc/login.defs</b> file
contains:

<ul>

<li>Values used for the group and user ID numbers.

</li>

<li>Parameters for passwords encryption in the shadow file.

</li>

<li>Password expiration values for user accounts.

</li>

</ul> </td>

</tr>

<tr> <td><b>/etc/skel</b></td> <td>The <b>/etc/skel</b> directory contains a
set of configuration file templates that are copied into a new user's home
directory when it is created, including the following files:

<ul>

<li><b>.bashrc</b>

</li>

<li><b>.bash_logout</b>

</li>

<li><b>.bash_profile</b>

</li>

<li><b>.kshrc</b>

</li>

</ul> </td>

</tr> </table>

Although it is possible to edit the **/etc/passwd** and **/etc/shadow** files
manually to manage user accounts, doing so can disable your system. Instead,
use the following commands to manage user accounts:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>useradd</b></td> <td>Create a user account. The following options
override the settings as found in <b>/etc/default/useradd</b>:

<ul>

<li><b>-c</b> adds a description for the account in the GECOS field of
<b>/etc/passwd</b>.

</li>

<li><b>-d</b> assigns an absolute pathname to a custom home directory
location.

</li>

<li><b>-D</b> displays the default values specified in the
<b>/etc/default/useradd </b> file.

</li>

<li><b>-e </b>specifies the date on which the user account will be disabled.

</li>

<li><b>-f</b> specifies the number of days after a password expires until the
account is permanently disabled.

</li>

<li><b>-g </b>defines the primary group membership.

</li>

<li><b>-G </b>defines the secondary group membership.

</li>

<li><b>-M </b>does not create<b> </b>the user's home directory.

</li>

<li><b>-m </b>creates the user's home directory (if it does not exist).

</li>

<li><b>-n, N </b>does not create a group with the same name as the user (Red
Hat and Fedora respectively).

</li>

<li><b>-p </b>defines the encrypted password.

</li>

<li><b>-r </b>specifies the user account is a system user.

</li>

<li><b>-s</b> defines the default shell.

</li>

<li><b>-u</b> assigns the user a custom UID. This is useful when assigning
ownership of files and directories to a different user.

</li>

</ul> </td> <td><b>useradd pmaxwell</b> creates the <i>pmaxwell</i> user
account<b>.  
useradd -c "Paul Morril" pmorril</b> creates the <i>pmorril</i> account with a
comment<b>.  
useradd -d /tmpusr/sales1 sales1</b> creates the <i>sales1</i> user account
with home directory located at <i>/tmpusr/sales1</i>.  
<b>useradd -u 789 dphilips</b> creates the <i>dphilips</i> account with user
ID <i>789</i>.</td>

</tr>

<tr> <td><b>passwd</b></td> <td>Assign or change a password for a user.

<ul>

<li><b>passwd</b> (without a username or options) changes the current user's
password.

</li>

<li>Users can change their own passwords. The root user can execute all other
<b>passwd</b> commands.

</li>

</ul>

Be aware of the following options:

<ul>

<li><b>-S </b><i><b>username</b> </i>displays the status of the user account.

<ul>

<li>LK indicates the user account is locked.

</li>

<li>PS indicates the user account has a password.

</li>

</ul>

</li>

<li><b>-l</b> disables (locks) an account. This command inserts a !! before
the password in the <b>/etc/shadow </b>file, effectively disabling the
account.

</li>

<li><b>-u</b> enables (unlocks) an account.

</li>

<li><b>-d</b> removes the password from an account.

</li>

<li><b>-n</b> sets the minimum number of days a password exists before it can
be changed.

</li>

<li><b>-x</b> <i>s</i>ets the number of days before a user must change the
password (password expiration time).

</li>

<li><b>-w</b> sets the number of days before the password expires that the
user is warned.

</li>

<li><b>-i</b><i> </i>sets the number of days following the password expiration
that the account will be disabled.

</li>

</ul> </td> <td> <b>passwd jsmith</b> changes the password for the
<i>jsmith</i> account.  
<b>passwd -d</b> removes the password from an account.  
<b>passwd -d jsmith</b> removes the password from the <i>jsmith</i> account.  
<b>passwd -x 40 jsmith</b> requires <i>jsmith</i> to change his password every
40 days.  
<b>passwd -n 10 jsmith</b> means that <i>jsmith</i> cannot change his password
for 10 days following the most recent change.<b>  
passwd -w 2 jsmith</b> means that <i>jsmith</i> will be warned 2 days before
his password expires.  
<b>passwd -i 7 jsmith</b> disables the <i>jsmith</i> account after 7 days if
the password is not changed.  
<b>passwd -l jsmith</b> locks the <i>jsmith</i> account.  
<b>passwd -u jsmith</b> unlocks the <i>jsmith</i> account.



</td>

</tr>

<tr> <td><b>usermod</b></td> <td>Modify an existing user account.
<b>usermod</b> uses several of the same switches as <b>useradd</b>. Be aware
of the following switches:

<ul>

<li><b>-c </b>changes the description for the account.

</li>

<li><b>-l</b> renames a user account. When renaming the account:

<ul>

<li>Use <b>-d</b> to rename the home directory.

</li>

<li>Use <b>-m</b> to copy all files from the existing home directory to the
new home directory.

</li>

</ul>

</li>

<li><b>-L </b>locks the user account. This command inserts a ! before the
password in the <b>/etc/shadow </b>file, effectively disabling the account.

</li>

<li><b>-U</b> unlocks the user account.

</li>

</ul> </td> <td><b>usermod -c "Paul Morril" pmorril</b> changes the comment
field for user <i>pmorril</i>.  
<b>usermod -l esmith -d /home/esmith -m ejones</b> renames the <i>ejones</i>
account to <i>esmith</i>, renames the home directory, and moves the old home
directory contents to the new location.  
<b>usermod -s /bin/tsch esmith</b> points the shell for <i>esmith</i> to
<i>/bin/tsch</i>.  
<b>usermod -U</b> <b>esmith</b> unlocks the <i>esmith</i> account.</td>

</tr>

<tr> <td><b>userdel</b> </td> <td>Remove the user from the system. Be aware of
the following options:

<ul>

<li><b>userdel <i>username</i></b> (without options) removes the user account.

</li>

<li><b>-r</b> removes the user's home directory.

</li>

<li><b>-f </b>forces the removal of the user account even when the user is
logged into the system.

</li>

</ul> </td> <td><b>userdel pmaxwell </b>deletes the <i>pmaxwell</i> account
while leaving the home directory on the hard drive.  
<b>userdel -r pmorril </b>removes both the account and the home
directory.</td>

</tr> </table>

