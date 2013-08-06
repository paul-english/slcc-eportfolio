---
layout: page
title:  Openssh Configuration Files And Commands
---

OpenSSH configuration files let administrators customize settings for SSH
access and availability. Configuration tasks include:

  * Configuring SSH _servers_ to determine whether clients can access them and which clients have access.
  * Configuring SSH _clients_ to use SSH and specify which servers they can access.
  * Configuring the firewall to allow traffic to pass through the ports that SSH uses. By default, it is port 22.

OpenSSH uses the following configuration files:

<table>

<tr> <td>File</td> <td>Description</td> <td>Examples</td>

</tr>

<tr> <td> <b>/etc/ssh/sshd_config</b></td> <td>The <b>/etc/ssh/sshd_config
</b> file configures the SSH daemon on the server system. Be aware of the
following commonly-needed options for configuring an SSH server:

<ul>

<li><b>AllowUsers </b>lists users allowed to use SSH. If an <b>AllowUsers</b>
line is used in the file, all users except those listed are denied access by
default.

</li>

<li><b>DenyUsers </b>lists users not allowed to use SSH. If a <i>DenyUsers</i>
line is used in the file, all users except those listed are granted access by
default. A <i>DenyUsers</i> entry overrides an <i>AllowUsers</i> entry.

</li>

<li><b>Protocol </b>specifies which protocols SSH allows when accessing the
SSH server.

<ul>

<li>Protocol 2 is more secure, and is supported on newer distributions. The
default is protocol 2.

</li>

<li>Protocol 1 is typically used on older systems.

</li>

</ul>

</li>

<li><b>ListenAddress </b>gives the addresses that SSH should use when
listening for requests. By default, the server listens on all IP addresses
assigned to it. Use this line to specify specific addresses.

</li>

<li><b>Port </b>specifies the port number. The default is 22. Use this line to
change the default.

</li>

<li><b>PasswordAuthentication </b>disables password authentication when set to
no.

</li>

<li><b>UsePAM</b> enables the Pluggable Authentication Modules (PAM) interface
between sshd and the system.

</li>

<li><b>PermitRootLogin </b>specifies whether users can log in as root over
SSH.

<ul>

<li>If set to no, then users must log in using standard credentials, but can
use the <b>su</b> command to elevate their privileges.

</li>

<li>The default is yes.

</li>

</ul>

</li>

</ul>

<b>Note</b>: Restart the sshd daemon to implement changes.

</td> <td><b>AllowUsers jsmith mkimball</b> grants access to the specified
users.  
<b>DenyUsers gedwards fjones </b>denies access to the specified users.  
<b>Protocol 1,2</b> allows the server to use either protocol.  
<b>ListenAddress 192.168.10.10:22</b> ensures that the server listen only on
the IP address specified.  
<b>port 11111</b> changes the SSH port from the default port to port 11111.  
 </td>

</tr>

<tr> <td> <b>/etc/ssh/ssh_config  
~/.ssh/config</b></td> <td>The <b>/etc/ssh/ssh_config </b>file configures
OpenSSH for all users on the client system. <b>~/.ssh/config </b>is a user-
specific hidden file which can override the configuration in <b>
/etc/ssh/ssh_config</b> file. Both files can be overridden using command line
options with the <b>ssh</b> command.

Be aware of the following commonly-needed options for configuring an SSH
client:

<ul>

<li><b>Protocol</b><i> </i>specifies which protocols SSH allows when accessing
the SSH server.

</li>

<li><b>StrictHostKeyChecking</b><i> </i>determines whether SSH clients can
accept keys from SSH servers not previously accessed. The keys of previously
accessed servers reside in one of the following directories:

<ul>

<li><b>/etc/ssh/ssh_known_hosts</b>

</li>

<li><b>~/.ssh/known_hosts</b>

</li>

</ul> <b>Note:</b> If this parameter is set to <b>yes</b>, then new keys must
be added manually using:  
<b>cat</b> <b> <i>keyfile.pub</i></b> <b>>> /etc/ssh/ssh_known_hosts</b>

</li>

<li><b>CheckHostIP </b>verifies that the supplied key matches the IP address
of the server when set to yes. This prevents IP spoofing, but might generate
warnings or refuse connection if the server changes its keys.

</li>

<li><b>Port </b>specifies the port that SSH uses.

</li>

<li><b>User </b>automatically logs in with the specified user name instead of
requesting a username.

</li>

</ul> </td> <td><b>Protocol 1,2</b> allows the client to connect using either
protocol.  
<b>StrictHostKeyChecking no </b>automatically adds new host keys to the known
hosts files. Other options are <i>yes</i> and <i>ask</i>. <i>Ask</i> is the
default.  
<b>port 11111</b> changes the SSH port from the default port to port 11111.  
<b>user jsmith</b> automatically uses jsmith as the user when logging in.</td>

</tr> </table>

The following table lists commands used in conjunction with SSH.

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td><b>which</b></td> <td>Verify if a package is installed on the
system.</td> <td> <b>which sshd</b> verifies that the SSH server daemon is
installed.<b>  
which ssh</b> verifies that the SSH client daemon is installed.</td>

</tr>

<tr> <td><b>service sshd</b><i> </i></td> <td>Manage the current state of the
SSH daemon on the server. Options include:

<ul>

<li><b>start </b>starts a daemon that is not currently running

</li>

<li><b>stop </b>halts a running daemon.

</li>

<li><b>restart </b>stops and restarts a daemon.

</li>

<li><b>status </b>shows the status of a single daemon or daemons.

</li>

</ul>

<b>Note</b>: As an alternative method, use the absolute path to the daemon
script and the option to configure the daemon (e.g., <b>/etc/rc.d/init.d/sshd
start</b>)

</td> <td> <b>service sshd</b><i> </i><b>start </b>starts the ssh daemon.  
<b>/etc/init.d/sshd start  </b>starts the ssh daemon.  
<b>service sshd status </b>shows whether the sshd daemon is running.<b>  
/etc/it.d/sshd status </b>shows whether the sshd daemon is running.</td>

</tr>

<tr> <td><b>ssh</b></td> <td>Make a secure connection from the SSH client to
the SSH server. Be aware of the following options:

<ul>

<li><b>-l </b>specifies the user account on the server. Without this option,
SSH uses the same user account name being used on the client computer.

</li>

<li><b><i>hostname</i></b> specifies the SSH server name, and could include a
domain name.

</li>

<li><b><i>commands</i></b> (optional) runs the command on the remote system
but displays the results on the local machine.

</li>

</ul> </td> <td><b>ssh -l bjones hs1 </b>logs in to the <i>hs1</i> computer as
<i>bjones</i>.  
<b>ssh -l bjones@hs1 ls -la /var/log</b> logs in to the <i>hs1</i> computer as
<i>bjones, </i>executes the<i> </i><b>ls -la /var/log </b>command on the
remote computer, then closes the connection.</td>

</tr>

<tr> <td><b>scp</b> </td> <td>Encrypt and copy files from a remote system over
the network. Be aware of the following options:

<ul>

<li><i><b>username </b></i>specifies the user account on the remote system.

</li>

<li><b><i>@hostname:remotefile </i></b>specifies the remote system and the
remote file.

</li>

<li><i><b>destination/filename</b></i> specifies where to location and name of
the new file.  If the new file name is omitted, the file is copied using the
original name.

</li>

</ul> </td> <td><b>scp bjones@hs1:hostfile ~/ </b>copies <i>hostfile</i> from
the server to the home directory on the client.  
<b>scp ~/clientfile bjones@hs2.mydomain.com:/home/bjones</b>/ copies
clientfile from the client computer to the home directory of <i>bjones</i> on
the server.  
<b>scp bjones@hs1.mydomain.com:/home/bjones/file1
bjones@hs2.mydomain.com:/home/bjones/</b> copies <i>file1</i> from <i>hs1</i>
to <i>hs2</i>.</td>

</tr>

<tr> <td><b>sftp</b> </td> <td>Transfer files securely from ftp servers. Be
aware of the following options:

<ul>

<li><i><b>username </b></i>specifies the user account on the remote system.

</li>

<li><b><i>@hostname </i></b>specifies the remote system.

</li>

</ul>

After logging in, use the same commands that are used when using <b> ftp</b>.
These include:

<ul>

<li><b>pwd</b> shows the current directory.

</li>

<li><b>get</b><i> file_name</i> copies a file from the ftp server.

</li>

<li><b>cdup</b> traverses up a directory

</li>

<li><b>dir</b> displays files in the current directory.

</li>

</ul> </td> <td><b>sftp bjones@ftp1.mydomain.com </b>connects to the FTP
server as <i> bjones</i>.</td>

</tr>

<tr> <td><b>slogin</b> </td> <td>Allows access to a shell on a remote
computer. It is identical to the <b> ssh</b> command. This is supported only
for backwards compatibility.</td> <td><b>slogin -l bjones hs1 </b>logs in to
the <i>hs1</i> computer as <i>bjones</i>.</td>

</tr> </table>

