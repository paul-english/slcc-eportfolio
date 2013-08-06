---
layout: page
title:  Openssh Facts
---

OpenSSH is a tool that encrypts network traffic over a subnet or Internet.
OpenSSH is an open version of Secure Shell (SSH) implemented on many Linux
distributions and is similar to other versions of SSH. SSH:

  * Uses a public and private key pair to encode and transfer a symmetric key that is used during the session. The public key is available to all users. The private key is only on the server and is never shared.
  * Can use associated key management software and scripts to automate the exchange of public keys. 
  * Allows encryption of other network protocols, such as the X server protocols.
  * Has two types:
    * SSH version 1 (SSH1) is an older, less secure version of SSH. SSH1 only supports RSA encryption.
    * SSH version 2 (SSH2) is the current standard SSH implementation. It can use either DSA or RSA encryption.

Computers use the following steps when establishing a session using SSH:

  1. A client running SSH establishes a connection to the server (any computer running SSH daemon (sshd)) over port 22.
  2. The computers determine which SSH version to use based on the specifications in the configuration files. Typically, this is SSH2.
  3. The server sends one of the following public keys from the **/etc/ssh/** directory to the client:
    * **ssh_host_key.pub** (SSH1 public key)
    * **ssh_host_rsa_key.pub** (SSH2 public key when using RSA)
    * **ssh_host_dsa_key.pub** (SSH2 public key when using DSA)
  4. When the client receives the public key from the server, it compares the key to the keys it has received and stored in one of the following files:
    * **/etc/ssh/ssh_known_hosts**
    * **~/.ssh/known_hosts**
**Note**: If the key is not present in either of these files, then the client prompts the user to accept and store the key. 
  5. The server and the client then use the Diffie-Hellman key exchange system to agree on a symmetric key that they use for the rest of the session. 
  6. The data is exchanged with symmetric encryption.

