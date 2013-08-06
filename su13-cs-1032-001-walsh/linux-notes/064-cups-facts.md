---
layout: page
title:  Cups Facts
---

CUPS (Common Unix Print System) is widely used on nearly every current Linux
distribution for managing printers and printing. CUPS has the following
components:

<table>

<tr> <td>Component </td> <td>Description</td>

</tr>

<tr> <td>Client</td> <td>Clients send files to the print server. When
configuring a print system, the client's <i>cupsd</i> daemons automatically
listen for broadcast signals from servers, and can connect to those servers.
</td>

</tr>

<tr> <td>Server</td> <td>Servers broadcast their availability over the network
for client connections. Other components of a CUPS print system are maintained
on the server. The <i>cupsd</i> daemon runs on the server and handles print
functions.</td>

</tr>

<tr> <td>Scheduler</td> <td>Schedulers are specialized Web servers that handle
IPP print requests. Schedulers:

<ul>

<li>Run on IP port 631.

</li>

<li>Have a built-in Web interface.

</li>

</ul> </td>

</tr>

<tr> <td>Queue</td> <td>A <i>queue</i> hold a list of print jobs sent to the
server. The path to the queue is <b>/var/spool/cups</b>. Files in
<b>/var/spool/cups</b> include:

<ul>

<li><b>c</b><i>print_job_number </i>represents the print job and filter
information.

</li>

<li><b>d</b><i>print_job_number </i>represents the stored document.

</li>

</ul> </td>

</tr>

<tr> <td>Filter</td> <td>A <i>filter</i> converts print jobs from the default
printer description language (PDL) into the languages used and understood by
the printer.

<ul>

<li>By default Linux uses the postscript PDL; however, many printers do not
use postscript, so the filter converts the print job into a PDL the printer
uses.

</li>

<li>Filters are located at <b>/usr/lib/cups/filter</b>.

</li>

</ul> </td>

</tr>

<tr> <td>Backend</td> <td>A <i>backend</i> is the interface between the
scheduler and the printer. Linux computers have several backends including:

<ul>

<li>Parallel

</li>

<li>Serial

</li>

<li>USB

</li>

</ul>

When the cupsd daemon starts, it queries each backend about printers attached
to the computer. The backends provide the cupsd daemon with printer
information including make, model, and capabilities for each connected
printer. Backends are located at <b>/usr/lib/cups/backend</b>.

</td>

</tr>

<tr> <td>Postscript Printer Descriptions (PPD)</td> <td>The Postscript Printer
Descriptions (PPD) are files that the <i>cupsd</i> daemon uses to determine
printer capabilities. These files are located at <b> /etc/cups/ppd</b>.</td>

</tr> </table>

The following are the steps CUPS uses when processing print jobs.

  1. The client sends the print job to the cupsd daemon on the server.
  2. The daemon creates the files and places them in the queue.
  3. Print jobs pass through the filters and are converted to the appropriate PDL.
  4. The backend sends the print job to the printer.
  5. The backend notifies the cupsd daemon when the job is completed, and the job is removed from the queue.

The cupsd daemon is configured using the **/etc/cups/cupsd.conf** file. Be
aware of the following common parameters in **/etc/cups/cupsd.conf**:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>ServerName</b></td> <td>Specify the name of the server broadcast
to cups clients.</td> <td><b>ServerName printserver.mynetwork.com</b></td>

</tr>

<tr> <td><b>ServerAdmin</b></td> <td>Specify an email address for the server
administrator</td> <td><b>ServerAdmin printhelp@mynetwork.com</b></td>

</tr>

<tr> <td><b>DocumentRoot</b></td> <td>Specify the directory where the client
documentation for CUPS resides. The default is
<b>/usr/share/doc/packages/cups</b>. </td> <td><b>DocumentRoot
/usr/share/doc/packages/cups</b></td>

</tr>

<tr> <td><b>LogLevel</b></td> <td>Specify the error severity level to be
logged.</td> <td><b>LogLevel warn</b></td>

</tr>

<tr> <td><b>Listen</b></td> <td>Specify the network addresses the server uses
when listening for print jobs.</td> <td><b>Listen 192.168.10.1:631</b> listens
for print jobs sent to 192.168.10.1:631.  
<b>Listen *:631</b> listens for print jobs sent to any address.  
<b>Listen localhost:631</b> listens only for print jobs from the local
computer.</td>

</tr>

<tr> <td><b>MaxCopies</b></td> <td>Limit the number of copies of a document
that can be printed for a single print job. The default is 100.</td>
<td><b>MaxCopies 50</b></td>

</tr>

<tr> <td><b>MaxJobsPerUser</b></td> <td>Limit the number of active print jobs
for a single user. The default is 0, meaning no restriction.</td>
<td><b>MaxJobsPerUser 100</b></td>

</tr>

<tr> <td><b>User</b></td> <td>Specify the user who owns the cupsd process. The
default is <i>lp</i>. </td> <td><b>User lp</b></td>

</tr>

<tr> <td><b>Group</b></td> <td>Specify the cupsd group. The default is
<i>lp</i>. </td> <td><b>Group lp</b></td>

</tr>

<tr> <td><b>MaxClients</b></td> <td>Limit the number of concurrent client
connections to the CUPS server. The default is 100.</td> <td><b>MaxClients
50</b></td>

</tr>

<tr> <td><b>Browsing</b></td> <td>Enable server broadcasts. The default is
<i>On</i>.</td> <td><b>Browsing On</b></td>

</tr>

<tr> <td><b>BrowseAddress</b></td> <td>Specify the address CUPS servers use to
broadcast servers. This must be set for broadcasts to work. The default is no
setting. Check this first if CUPS clients do not receive broadcasts.</td>
<td><b>BrowseAddress 192.168.2.255:631  
BrowseAddress printserver.mynetwork.com:631 </b> </td>

</tr>

<tr> <td><b>BrowseInterval</b></td> <td>Set the time in seconds between
broadcasts. The default is 30 seconds. If this is set above 60, Printers might
timeout and disappear from the printer list.</td> <td><b>BrowseInterval
30</b></td>

</tr>

<tr> <td><b>BrowseOrder</b></td> <td>Specify whether the server allows or
denies print jobs by default, then specifies the order in which the
BrowseAllow and BrowseDeny parameters are checked.</td> <td><b>BrowseOrder
allow,deny</b> denies by default, then checks the BrowseAllow parameter, and
then the BrowseDeny parameter.  
<b>BrowseOrder deny,allow</b> allows by default, then checks the BrowseDeny
parameter, and then the BrowseAllow parameter.</td>

</tr>

<tr> <td><b>BrowseAllow</b></td> <td>Specify computers and networks that can
send print jobs.</td> <td><b>BrowseAllow all</b> accepts all print jobs.  
<b>BrowseAllow 192.168.1.0/255.255.255.0</b> allows print jobs from the <i>
192.168.1.0</i> domain with a subnet of <i>255.255.255.0</i>.  
<b>BrowseAllow *.mynetwork.com</b> allows print jobs from all computers on the
domain.</td>

</tr>

<tr> <td><b>BrowseDeny</b></td> <td>Specify computers that cannot send print
jobs.</td> <td><b>BrowseDeny all</b> rejects all print jobs. Other options are
identical to BrowseAllow.</td>

</tr> </table>

The following table describes the utility used to configure CUPS:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Example</b></td>

</tr>

<tr> <td><b>cupsctl</b></td> <td>Configure the <b>/etc/cups/cupsd.conf</b>
file. When used with no options, the command displays current settings.
Options include:

<ul>

<li><b>\--remote-admin</b> enables remote administration of the server.

</li>

<li><b>\--share-printers</b> enables the sharing of local printers with other
computers.

</li>

<li><b>\--remote-printers</b> enables the display of remote printers shared
via CUPS.

</li>

</ul>

<b>Note</b>: Use <b>\--no</b> in front of a command to disable an option.

</td> <td><b>cupsctl</b> displays the settings of the cupsd.conf file.  
<b>cupsctl --remote-admin</b> enables remote administration of the server.  
<b>cupsctl</b> <b>\--no-share-printers</b> will prevent the sharing of local
printers.</td>

</tr>

<tr> <td> <b>lppasswd -g sys -a root</b></td> <td>Create the CUPS root user
and password.

<ul>

<li>CUPS requires a CUPS root user to access the Web administration utility.

</li>

<li>The CUPS root user must be a member of the <i>sys</i> group.

</li>

<li>CUPS user information resides in the <b>/etc/passwd.md5</b> file instead
of <b>/etc/passwd</b>.

</li>

</ul>

Be aware of the following options:

<ul>

<li><b>-g</b> <b>sys </b>specifies the group.

</li>

<li><b>-a</b> specifies the username.

</li>

</ul></td> <td><b>lppasswd -g sys -a root  
</b>Enter password:  
Enter password again:

The lines above create the CUPS root user account and password.

</td>

</tr> </table>

Keep the following in mind when using CUPS:

  * Most Linux distributions install CUPS by default; however, if CUPS is not installed, use **yum** or **apt-get** to install the CUPS package.
  * Use the init script to restart CUPS after making configuration changes.
  * To access the Web-based CUPS administration utility, go to **http:\\\localhost:631** or **http:\\\127.0.0.1:631**.

