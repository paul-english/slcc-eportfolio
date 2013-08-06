---
layout: page
title:  Ssh Port Tunneling Facts
---

Secure Shell (SSH) port tunneling encrypts data from non-secure protocols
before sending the data over a network. Non-secure protocols, such as email
and X server traffic, are commonly tunneled through SSH. The SSH port
tunneling process works as follows:

  1. The client sends the non-secure protocol information to the port on the server running the SSH daemon.
  2. The SSH daemon intercepts all traffic sent to that port, encrypts it, and sends it to the SSH client.
  3. The SSH client receives the encrypted traffic, decrypts it, and forwards it to the default port for the client.
  4. The client receives the data on its usual port.

The **/etc/ssh/sshd_config ** configures the SSH daemon on the server. Be
aware of the following commonly-needed options for configuring an SSH server:

  * **AllowTcpForwarding** allows TCP traffic to be sent from the SSH daemon when set to yes.
  * **ForwardX11 **specifies that clients to which requests are forwarded are regarded as untrusted, and have restricted access to certain GUI features. The default is no. 
  * **ForwardX11Trusted **specifies that clients to which requests are forwarded are regarded as trusted, and have unrestricted access to all GUI features. The default is yes. 
  * **X11Forwarding **is similar to setting **ForwardX11Trusted** to yes, but is used with older distributions. The default is no.

Use the following commands to create an SSH port tunnel:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Example</td>

</tr>

<tr> <td> <b>ssh</b></td> <td>Set up an SSH tunnel from the client to the
server for textual traffic. Be aware of the following options:

<ul>

<li><b>-f </b>runs SSH in the background after the password prompt.

</li>

<li><b>-N </b>ensures that SSH does not execute a remote command.

</li>

<li><b>-L </b>specifies the port numbers and server name.

</li>

<li><b>-g </b>overrides configuration file settings and creates a tunnel if
needed.

</li>

<li><b><i>tunnel</i></b><i><b>port</b> </i>specifies the SSH port for the
encrypted data. Only the root user can set the SSH port to a privileged port
(i.e., port 1024 or lower.)

</li>

<li><b><i>server</i></b> specifies the server running the SSH daemon.

</li>

<li><i><b>port </b></i>specifies the default port for non-secure protocol.

</li>

</ul> </td> <td><b> ssh -f -N -L 2345:mail.mydomain.com:110
userbob@mail.mydomain.com </b>sets up an SSH port tunnel for POP3 mail traffic
over port 2345. </td>

</tr>

<tr> <td> <b>ssh -X</b></td> <td>Set up an SSH tunnel from the client to the
server for X server traffic. Be aware of the following options:

<ul>

<li><b>-l </b>specifies the username of the user account on the remote system.

</li>

<li><b><i>server</i></b> specifies the server name and domain running the SSH
daemon.

</li>

</ul> </td> <td><b> ssh -X -l mtrance hn3.mydomain.com </b>sets up an SSH port
tunnel for X server traffic. </td>

</tr> </table>

Use the following commands to send _unencrypted_ X server traffic between a
client and server:

<table>

<tr><td>Use...</td><td>To...</td><td>Example</td>

</tr>

<tr> <td> <b>xhost +<i>servername</i></b></td> <td>Configure the client to
receive unencrypted X server traffic.</td> <td> <b>xhost +hn3.mydomain.com<i>
</i></b>configures the client to accept unencrypted X server traffic from
hn3.mydomain.com.</td>

</tr>

<tr> <td> <b>DISPLAY=<i>host_name</i>:0.0  
export DISPLAY  
 </b></td> <td>Configure and export the DISPLAY environment variable to send
unencrypted X server traffic to the specified client.</td> <td>
<b>DISPLAY=hn2:0.0 </b>configures the server to display unencrypted X server
traffic on hn2.<b>  
export DISPLAY </b>exports the DISPLAY environment variable.</td>

</tr> </table>

