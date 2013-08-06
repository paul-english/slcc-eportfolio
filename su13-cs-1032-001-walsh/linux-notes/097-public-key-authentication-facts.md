---
layout: page
title:  Public Key Authentication Facts
---

Public key authentication uses a public key instead of a password to log in to
a computer. The computer uses the following method to authenticate using a
public key:

  1. The client specifies which public key the server uses for authentication, and the server checks to ensure the key has previously been authenticated to the server.
  2. If the key is known to the server, it chooses a random number, encrypts it with the public key, and sends it to the client.
  3. The client decrypts the number with a private key, uses its own public key and random number to create a hash (MD5 checksum). The client sends the hash back to the server. 
  4. The server uses the public key and the random number to create its own hash (MD5 checksum) and then checks whether both hash values match.
  5. If the hashes match, the server grants access to the user. If the hashes do not match, the user is prompted to log in using a password.

Use the following commands and files for public key management:

<table>

<tr> <td>Use...                </td> <td>To...</td> <td>Example</td>

</tr>

<tr> <td> <b>/etc/ssh/sshd_config</b></td> <td>Configure the server to accept
public key authentication. Be aware of the following commonly-needed options
for configuring an public key authentication on the server:

<ul>

<li><b>PubKeyAuthentication </b>enables/disables public key authentication on
the server.

</li>

<li><b>AuthorizedKeysFile <i>location</i> </b>specifies the location of the
file that contains the public keys.

</li>

</ul> </td> <td><b>PubKeyAuthentication yes </b>enables public key
authentication on the server.<b>  
AuthorizedKeysFile .ssh/authorized_keys </b> specifies the location of the
file that contains the public keys.</td>

</tr>

<tr> <td> <b>ssh-keygen </b></td> <td>Create a key on the client for use when
authenticating to a server. Be aware of the following <b>ssh-keygen </b>
options:

<ul>

<li><b>-t</b> <b>dsa </b>creates a DSA key pair (i.e., id_dsa and id_dsa.pub).

</li>

<li><b>-t rsa</b> creates an RSA key pair (i.e., id_rsa and id_rsa.pub). This
is the default.

</li>

</ul> </td> <td><b>ssh-keygen -t dsa </b>creates a DSA key pair.<b>  
ssh-keygen -t rsa </b>creates an RSA key pair.  
<b>ssh-keygen </b>creates an RSA key pair.</td>

</tr>

<tr> <td> <b>scp</b></td> <td>Securely copy the client's public key file to
the server.</td> <td> <b>scp ~/.ssh/id_rsa.pub
bjones@hs2.mydomain.com:/home/bjones</b>/<b> </b> copies id_rsa.pub to the
home directory of bjones.</td>

</tr>

<tr> <td> <b>ssh</b></td> <td>Log in to the server.</td> <td><b>ssh -l bjones
hs1 </b>logs in to the <i>hs1</i> computer as <i>bjones</i>.</td>

</tr>

<tr> <td> <b>cat</b></td> <td>Append the public key to the
<b>~/authorized_keys</b> file. Be aware of the following:

<ul>

<li>Overwriting the file deletes all other keys.

</li>

<li>If the same user logs in from multiple clients, the file must have all
client keys in it.

</li>

<li>Always remove the <i>rsa.pub </i>file after appending it to the
<b>~/authorized_keys</b> file.

</li>

</ul> </td> <td> <b>cat id_rsa.pub >> ~/.ssh/authorized_keys</b> appends the
<i>id_rsa.pub</i> file to the end of the <i>authorized_keys</i> file.</td>

</tr>

<tr> <td> <b>ssh-agent bash  
ssh-add </b></td> <td>To configure the client to automatically provide the
private key passphrase when needed so that it does not have to be typed for
every new connection to a server.

<ol>

<li>Use <b>ssh-agent bash</b> to enable passphrase agent.

</li>

<li>Use <b>ssh-add </b>to specify the name of the private key to add to the
agent. For protocol 2, this is one of the following:

<ul>

<li><b>~/.ssh/id_rsa</b>

</li>

<li><b>~/.ssh/id_dsa</b>

</li>

</ul>

</li>

</ol>

Be aware of the following:

<ul>

<li>After the <b>ssh-add</b> command, type the passphrase when prompted. The
passphrase stays in memory while the user is logged in to the client.

</li>

<li>SSH1 uses <b>ssh-add ~/.ssh/identity</b>.

</li>

</ul> </td> <td> <b>ssh-agent bash</b> enables passphrase automation.<b>  
ssh-add ~/.ssh/id_rsa </b>specifies the id_rsa file as the private key.</td>

</tr> </table>

