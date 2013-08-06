---
layout: page
title:  The Root User And Sudoers File
---

The root user account is the Linux system _superuser_, and can perform any
task. Some utilities do not work if the administrator is not logged in as the
root user. The root account is created during the installation process, and it
receives the account number 0 (zero); in contrast, normal (standard) user
accounts receive ascending numbers beginning at 500 or 1000 depending on the
distribution.

To protect the root user account, use the following guidelines:

  * When performing tasks that require the root user account, use the **su** command to switch to the root user and execute the command; then use the **exit** command to revert back to the regular user account.
  * As a general rule, create a user account that gives sufficient permissions to perform most of the daily tasks. Use this account instead of the root user account when logging in to the system. 

To give standard user accounts the permissions to execute commands as the root
user, use the **sudo** command coupled with the **/etc/sudoers** file. Be
aware the following facts about the **sudo** command and the **/etc/sudoers**
file:

  * When users need to execute the command, they use the **sudo** command followed by the command they want to execute. Users are prompted for a password to execute the command. This is the current user account password, not the root account password. 
  * Users and the commands they are entitled to execute are specified in the **/etc/sudoers** file.
  * The **/etc/sudoers** file can only be edited using the **visudo** command. 
  * **sudo **logs information about the users and the commands they run as well as failed attempts to use **sudo** in the **/var/log/security** log. 

The following table describes the sections used to configure the
**/etc/sudoers** file:

<table>

<tr> <td>Section</td> <td>Description</td> <td><b>Examples</b></td>

</tr>

<tr> <td> <b>User_Alias</b></td> <td>User_Alias<b> </b>specifies a set of
users who are allowed to execute a specific set of commands using the
<b>sudo</b> command.</td> <td><b>User_Alias INSTALLERS = jsmith, psimms</b>
adds the users <i>jsmith</i> and <i>psimms</i> to the <i>INSTALLERS</i> alias.
Permissions assigned to this alias are grated to these users.</td>

</tr>

<tr> <td> <b>Cmnd_Alias</b></td> <td>Cmnd_Alias specifies a set of commands
that users can execute using the <b>sudo</b> command.</td> <td><b>Cmnd_Alias
INSTALL = /bin/rpm, /usr/bin/up2date, /user/bin/yum</b> assigns the
<b>rpm</b>, <b>up2date</b>, and <b>yum</b> commands to the <i>Install</i>
alias. Users granted access to the <i>Install</i> alias can execute these
commands.</td>

</tr>

<tr> <td> <b>Host_Alias</b></td> <td>Host_Alias<b> </b>specifies a list of
computers on which <b>sudo</b> users can perform commands. </td>
<td><b>Host_Alias FILESERVERS = fs1, fs2, fs3</b> adds the three computers to
the alias. Users assigned to this alias can run sudo commands on the three
computers.  
<b>Host_Alias EVERYWHERE = *.mydomain.com</b> creates an alias that grants
permissions for all computers on the <i>mydomain</i> network.</td>

</tr>

<tr> <td> <b>Runas_Alias</b></td> <td>Runas_Alias specifies a list of user
names that are used when running commands. Usually this is just
<i>root</i>.</td> <td><b>Runas_Alias DATABASE = oracle, sybase</b> specifies
that <b>sudo</b> commands are run as the <i>oracle</i> or <i>sybase</i>
user.</td>

</tr> </table>

Entries in the **/etc/sudoers ** file use the following syntax:

> _User Host = Runas_User Authentication Command(s)_

The following table describes the entry options in the **/etc/sudoers ** file:

<table>

<tr> <td>User</td> <td>Host</td> <td>Runas_User</td> <td>Authentication</td>

</tr>

<tr> <td>The <i>user</i> is the user identified as one of the following:

<ul>

<li>Username as found in <b>/etc/passwd</b>

</li>

<li>Group name as found in<b> /etc/group</b>

</li>

<li>User_Alias as found in <b>/etc/sudoers</b>

</li>

</ul></td> <td>The <i>host</i> is the system where the commands may run.

It is identified through the Host_Alias entry in <b>/etc/sudoers</b>.



</td> <td>The <i>Runas_User </i>is user or group to run the

If the <i>Runas_User </i>is omitted, the default is <i>root.</i>

</td> <td>The <i>authentication</i> parameter requires a password before using
the command. Option are:

<ul>

<li><b>PASSWD:</b> requires the user to enter their password as found in the
<b>/etc/shadow</b> file for users or <b>/etc/gshadow</b> for groups.

</li>

<li><b>NOPASSWD:</b> no password is required.

</li>

</ul>

If the <i>authentication</i> is omitted, the default is <b>PASSWD:</b>.

</td>

</tr> </table>

The following are examples of entries in the **/etc/sudoers** file:

<table>

<tr> <td>Example</td> <td>Description</td>

</tr>

<tr> <td><b>root ALL= (ALL) ALL</b></td> <td>Allows <i>root</i>, on any
computer, as any user, to run any program. </td>

</tr>

<tr> <td><b>%admin ALL = (ALL) ALL</b></td> <td>Allows the <i>admin</i> group,
on any computer, as any user, to run any program.</td>

</tr>

<tr> <td><b>INSTALLERS EVERYWHERE = NOPASSWD: INSTALL</b></td> <td>Allows the
users specified in the <i>INSTALLERS</i> user alias, on the computers
specified in the <i>EVERYWHERE</i> host alias, to perform commands specified
in the <i> INSTALL</i> command alias. The <i>NOPASSWD:</i> tag allows them to
run commands without typing their password.</td>

</tr>

<tr> <td> <b>treid ALL= /sbin, /usr/sbin</b></td> <td>Allows user
<i>treid</i>, on any computer, to run any command in the <b>/sbin </b>and
<b>/usr/bin</b> directories.</td>

</tr>

<tr> <td><b>#Defaults targetpw </b></td> <td>Comments the line out so the root
password is not required for the <b> sudo</b> commands. </td>

</tr>

<tr> <td><b>#ALL ALL = (ALL) ALL</b></td> <td>Comments the line out so that
all users do <i>not</i> have permissions for all <b>sudo </b>commands. </td>

</tr> </table>

The following table describes the commands for using the _superuser _account
and switching users:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td> <b> su</b></td> <td>Switch to the root user account. Be aware of the
following <b>su </b> options:

<ul>

<li><b>su -l </b><i>user_name </i>switches to the specified user in a login
shell.

</li>

<li><b>su </b><i>user_name </i>(without the dash, but with the username)
switches to the user.

</li>

<li><b>su -</b> <i>user_name </i>(with the dash and username) switches to the
user and loads the user's environmental variables.

</li>

<li><b>su - </b>(with the dash, but no username) switches to the <i>root</i>
user and loads the <i>root</i> user's environmental variables.

</li>

<li><b>su </b>(no dash or username) switches to the <i>root</i> user and but
<i>does not</i> load the root user's environmental variables.

</li>

<li><b>-c "<i>command</i>" </b>executes a single command, logging in as the
root user.

<ul>

<li>The command is enclosed in either single or double quotation marks.

</li>

<li>Include <b>-l <i>user</i></b> to execute the command as another user.

</li>

</ul>

</li>

</ul>

Note:<b> su</b> requires the password of the user except when switching from
root to a normal user.

</td> <td><b>su -l jsomes </b>switches to the jsomes user account with jsomes
environment variables.<b>  
su -</b> switches to the root account using the correct environment variables.  
<b>su -c "ls /home/rgurate" </b>switches to the root user and executes the
<b>ls</b> command on the user <i>rgurate's</i> home directory. </td>

</tr>

<tr> <td><b>exit</b></td> <td>Return to account from which the <b>su</b>
command was typed. When no <b>su</b> command has been typed, <b>exit</b>
terminates the shell. When using a computer that uses a shell exclusively,
<b>exit</b> logs the user out.</td> <td>  
[root@ls4 ~]# <b>exit  
</b>logout<b>  
</b>[jsomes@ls4 ~]$</td>

</tr>

<tr> <td><b>gnomesu</b></td> <td>Open graphical applications as the root user.

<b>Note</b>: This application only works on the GNOME desktop manager. The KDE
desktop manager has a similar utility named <i>kdesu</i>.

</td> <td><b>gnomesu nautilus</b> opens the nautilus file browser as the root
user account.</td>

</tr>

<tr> <td><b>logout</b></td> <td>Log out of the system, while leaving the
system powered on. Newer distributions use <b>exit</b> exclusively.</td>
<td><b>logout</b> logs the user out of the shell. It is identical to <b>
exit</b>.</td>

</tr>

<tr> <td><b>sudo</b></td> <td>Execute a command as the root user. To use this
command, first type sudo, than type the command as you normally would.</td>
<td><b>sudo yum install python.i686</b> installs the python package as the
root user.</td>

</tr>

<tr> <td><b>visudo</b></td> <td>Open the <b>/etc/sudoers</b> file for editing.
The command opens the VI editor, to edit the file, but checks the file for
errors when exiting from VI.</td> <td> </td>

</tr> </table>

