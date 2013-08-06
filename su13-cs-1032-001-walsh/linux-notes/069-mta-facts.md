---
layout: page
title:  Mta Facts
---

A Mail Transfer Agent (MTA) sends messages between clients on a local system
or over the Internet. MTAs:

  * Receive mail from a Mail User Agent (MUA). An MUA is an email application such as Mozilla Thunderbird or Microsoft Outlook.
  * Send/receive messages to/from other MTAs using Simple Mail Transfer Protocol (SMTP).
  * Receive messages from MUAs using Simple Mail Transfer Protocol (SMTP) by default
  * Send messages to MUAs using Post Office Protocol 3 (POP3) or Internet Message Access Protocol (IMAP) when sending and receiving messages. IMAP has a few advantages over POP3. IMAP:
    * Can download the entire message or only the message header.
    * Allows messages to be kept in the message store.
    * Allows creation of custom folders.
  * Are used to relay messages from several daemons, including **cron** and **at**, when jobs finish running.

The following are several of the most common MTA types on a Linux system:

<table>

<tr> <td>Type</td> <td>Details</td>

</tr>

<tr> <td>Sendmail</td> <td> Is an older MTA, but is still widely used. It is
somewhat more complex to configure than other MTA's. Sendmail:

<ul>

<li>Is the default MTA used on many distributions.

</li>

<li>Is non-modular (a single program.)

</li>

<li>Uses an init script is located at <b>/etc/rc.d/init.d/sendmail</b>.

</li>

</ul> </td>

</tr>

<tr> <td>Postfix </td> <td> Is the default MTA on many SUSE distributions.
Postfix

<ul>

<li>Is modular (i.e., made up of multiple programs).

</li>

<li>Has simplified configuration mechanisms.

</li>

</ul></td>

</tr>

<tr> <td>qmail </td> <td> Is an additional MTA that is not installed by
default on any distribution. Qmail:

<ul>

<li>Is modular.

</li>

<li>Implements several security features.

</li>

<li>Has simplified configuration mechanisms.

</li>

<li>Implements additional protocols:

<ul>

<li>Quick Mail Queuing Protocol (QMQP) allows the sharing of email queues
among different MTAs.

</li>

<li>Quick Mail Transport Protocol (QMTP) is a transmission protocol similar to
SMTP, but considered to be faster.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Exim </td> <td> Is the default MTA only on a very few distributions.
Exim:

<ul>

<li>Is non-modular.

</li>

<li>Has simplified configuration mechanisms.

</li>

</ul> </td>

</tr> </table>

Use the following to manage messages:

<table>

<tr> <td>Utility/File</td> <td>Description</td> <td>Examples</td>

</tr>

<tr> <td><b>mail</b></td> <td>Sendmail uses the <b>mail</b> command to send
and receive messages from the mail server:

<ul>

<li>To manage messages for the local user from the mail spool, type
<b>mail</b>.

<ul>

<li>Type the number of the message to read a message at the '<b>?</b>' prompt.

</li>

<li>Type <b>d </b>and the message number to delete the message at the
'<b>?</b>' prompt.

</li>

<li>Type <b>q</b> to exit the mail prompt at the '<b>?</b>' prompt.

</li>

</ul>

</li>

<li>To send mail to a user on the local network:

<ol>

<li>Type <b>mail</b> <i>user_name@domain</i>.

</li>

<li>Type a subject and press enter.

</li>

<li>Type the message, then press return to start a new line.

</li>

<li>Press Ctrl+d to send the message.

</li>

</ol>

</li>

<li>Use <b>mailq</b> or <b>sendmail -bp </b>to display the mail queue.

</li>

<li>Use <b>sendmail -q</b> to deliver all queued mail.

</li>

<li>Use <b>sendmail -bd</b> to start the sendmail daemon.

</li>

</ul></td> <td> <b>mail jdoe</b> sends a mail over the network to the user
jdoe.  
<b>mail</b> <b>jdoe@gmail.com </b>sends an email to the specified email
address. <b>  
? 4 </b>displays message four.  
<b>? d4</b> deletes message four.  
<b>? q</b> exits the mail prompt.  
<b>mailq</b> displays the mail queue for the current user.</td>

</tr>

<tr> <td><b>/etc/aliases.db</b></td> <td><b>/etc/aliases.db</b> is a binary
database that stores the aliasing information for sendmail. Be aware of the
following details:

<ul>

<li>The<b> /etc/aliases </b>file contains the list of sendmail email aliases
in text format.

</li>

<li>Use the <b>newaliases</b> command to create or update
<b>/etc/aliases.db</b> from the<b> /etc/aliases </b>file. <b>newaliases</b> is
identical to <b> sendmail -bi</b>.

</li>

</ul> </td> <td><b>root:     jdoe</b> sends all mail to root to jdoe's
inbox.</td>

</tr>

<tr> <td><b>~/.forward</b></td> <td><b>/home/<i>user</i>/.forward</b> forwards
messages from the local user to a user specified in the file.

<ul>

<li>Use this for temporary forwarding.

</li>

<li>Type the name of the user or address on a single line.

</li>

</ul>

<b>Note:</b> Forwarded email messages do not get saved in the original
account.

</td> <td><b>jdoe </b>forwards the mail to the user jdoe over the local
network.  
<b>jdoe@gmail.com</b> forwards the mail to the specified account.</td>

</tr>

<tr> <td><b>/var/spool/mail</b></td> <td> Each user account on the system has
a mail file in the<b> /<em>var</em>/<em>spool</em>/<em>mail</em></b>
directory. When new mail arrives, Linux tacks it onto the end of the
recipient's mail file. </td> <td><b>/var/spool/mail/gshant </b>holds email for
the <i>gshant</i> user account.</td>

</tr> </table>

