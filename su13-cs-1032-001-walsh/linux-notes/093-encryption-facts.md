---
layout: page
title:  Encryption Facts
---

Encryption is a security technique that encodes information so that only
someone with the proper key can decode it. Be aware of the following
encryption types:

<table>

<tr> <td>Type</td> <td><b>Description</b></td>

</tr>

<tr> <td>Symmetric</td> <td><i>Symmetric key encryption</i> (also known as
<i>secret key encryption, pre-shared key</i> or <i>private key encryption</i>)
uses only one key to encrypt and decrypt data.

<ul>

<li>Symmetric encryption is well suited for bulk encryption of less sensitive
data because it is less CPU-intensive than other encryption methods.

</li>

<li>Before communications begin, both parties must exchange the shared secret
key using a secure channel. This is often done manually or with some form of
asymmetric key cryptography.

</li>

<li>Each pair of communicating entities requires a unique shared key. This
means that the number of keys required grows exponentially as the number of
communication partners grows. For example, 1,000 users in a system would
require the generation of almost 500,000 different keys.

</li>

<li>The <i>key space</i> is typically short, ranging from 56-bits to a maximum
of 512-bits. (As the number of bits in the key increases, so does the strength
of the encryption. However, the greater the number of bits in the key, the
more CPU resources are required to perform the encryption.)

</li>

</ul></td>

</tr>

<tr> <td>Asymmetric</td> <td><i>Asymmetric encryption</i> (also known as
<i>public key encryption</i>) uses two keys that are mathematically related.
Both keys together are called the <i>key pair</i>.

<ul>

<li>The <i>public</i> key is made available to anyone; the <i> private</i> key
is kept secret.

</li>

<li>Use one key to encrypt and the other to decrypt. For example, if data is
encrypted with the public key, use the private key to decrypt the data.

</li>

<li>The strength of an asymmetric encryption system lies in the secrecy and
security of its private keys. If the private key is ever discovered, a new key
pair must be generated.

</li>

<li>Asymmetric encryption of large amounts of data is slow and requires high
CPU usage. Processing speeds are much slower (about 1,000 times slower) than
symmetric key encryption.

</li>

<li>Asymmetric encryption requires fewer keys than symmetric key encryption,
because only two keys per user are required (not a key for every communicating
partner).

</li>

</ul> </td>

</tr> </table>

Be aware of the following standards for symmetric and asymmetric encryption:

<table>

<tr> <td>Type</td> <td><b>Description</b></td>

</tr>

<tr> <td>Symmetric</td> <td>Data Encryption Standard (DES) is a very popular
encryption standard created by the National Security Agency. DES can be easily
broken. </td>

</tr>

<tr> <td>Triple DES (3DES) is an enhanced version of DES. 3DES applies DES
three times, and uses a 168-bit key. </td>

</tr>

<tr> <td>AES (Advanced Encryption Standard) is an improved version of Triple
DES that supports encryption key lengths of up to 256 bits.</td>

</tr>

<tr> <td><i>Blowfish</i> is a keyed, symmetric block cipher that was intended
to be free of the problems associated with other algorithms and replace DES.
Blowfish uses 64-bit blocks and key lengths anywhere from 32 bits to 448 bits.
</td>

</tr>

<tr> <td>Asymmetric</td> <td>Rivest, Shamir Adleman (RSA) is based on
factoring large numbers into their prime values. It was developed by Rivest,
Shamir and Adleman. RSA has key-length ranges from about 512 bit to 8,000 bits
(2401 digits). </td>

</tr>

<tr> <td><i>DSA</i> (Digital Signature Algorithm) is a United States
Government encryption standard often used for digital signing. DSA currently
supports Secure Hashing Algorithm-1 (SHA-1), which uses key lengths between
160 and 256 bits, or SHA-2<i>, </i> which uses key lengths between 256 and
1024 bits.</td>

</tr>

<tr> <td>The <i>Diffie-Hellman Key Exchange </i>was the first asymmetric
algorithm. It was developed by Whitfield Diffie and Martin Hellman. It is a
<i>key agreement protocol</i> that generates symmetric keys simultaneously at
sender and recipient sites over non-secure channels. The Diffie-Hellman key
exchange:

<ul>

<li>Provides for key distribution and does not provide any cryptographic
services.

</li>

<li>Is based on calculating discreet logarithms in a finite field.

</li>

<li>Is used in many algorithms and standards such as DES.

</li>

<li>Is subject to man in the middle attacks and requires strong authentication
to validate the end points.

</li>

</ul> </td>

</tr> </table>

