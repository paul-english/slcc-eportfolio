---
layout: page
title:  Gnupg Facts
---

Gnu Privacy Guard (GnuPG) is an encryption tool that encrypts and digitally
signs email, and also encrypts documents. GnuPG is an implementation of the
Pretty Good Privacy (PGP) protocol. It uses public/private key encryption to
secure documents. Be aware of the following commands and files when using
GnuPG:

<table>

<tr> <td>Use...</td> <td>To...</td> <td><b>Example</b></td>

</tr>

<tr> <td><b>which gpg</b></td> <td>Determine whether the GnuPG package is
installed on the system. </td> <td>[root@:ls4 ~]<b>which gpg  
</b>user/bin/gpg  
  
Shows the GnuPG package is installed on the system.</td>

</tr>

<tr> <td><b>gpg</b></td> <td>Configure the GnuPG keys and other aspects of
GnuPG. Be aware of the following options:

<ul>

<li><b> \--gen-key</b> creates a key pair.

</li>

<li><b>\--export <i>name</i> > gpg.pub </b>creates a public key named gpg.pub.

</li>

<li><b>\--import </b><i><b>filename</b> </i>adds public keys from other people
to the GnuPG key ring.

</li>

<li><b>\--list-keys</b> displays all the keys on the key ring.

</li>

<li><b>\--out <i>new_encrypted_file</i> \--recipient <i>name</i> \--armor
--encrypt <i>original_file_name </i></b>encrypts a file for an associate.

</li>

<li><b>\--out <i>decrypted_file_name</i> \--decrypt <i>encrypted_file_name</i>
</b>decrypts a file from an associate.

</li>

<li><b>\--clearsign <i>file_name</i></b> digitally signs a file.

</li>

<li><b>\--verify <i>file_name</i></b> compares the file against all keys in
the key ring for a valid signature.

</li>

<li><b>\--gen-revoke <i>key-ID</i></b> creates a key revocation certificate.

</li>

</ul>

<b>Note</b>: To revoke a public key on a key server:

<ol>

<li>Revoke the key on a local system using the key revocation certificate.

</li>

<li>Send the revoked key to the key server.

</li>

</ol> </td> <td><b>gpg --gen-key</b> starts the process of creating a GnuPG
key pair.  
<b>gpg --export jjones@acme.biz > gpg.pub</b> creates a public key that people
can use to send email to <i>jjones</i>.  
<b>gpg --out Secret.txt --recipient jjones@acme.biz --armor --encrypt
Report.txt</b> encrypts <i>Report.txt</i> using the private key associated
with<i><b> </b>jjones@acme.biz</i> and creates an encrypted file named <i>
Secret.txt</i>.  
<b>gpg --out Report.txt --decrypt Secret.txt </b>decrypts <i>Secret.txt</i>
and creates a file named <i>Report.txt</i>.  
<b>gpg --clearsign Report</b> creates a file named Report.asc. Report.asc
contains the original text along with a PGP signature hash.  
<b>gpg --verify Report.asc</b> uses the public keys to decrypt the hash
signature in the <i>Report.asc</i> file and compare it to the original text.
This option tries all public keys on the GnuPG key ring until it finds a
match. If a match is found, it verifies whether the text is unchanged.  
<b>gpg --out revoke.asc --gen-revoke A83B65D9 </b>creates a key revocation
certificate for the A83B65D9 key.  
<b>gpg</b> <b>\--import revoke.asc</b><i> </i>adds the key revocation
certificate to a system. </td>

</tr> </table>

