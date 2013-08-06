---
layout: page
title:  Print Management Commands
---

The Line Printer Daemon (LPD) is the older print management daemon for Linux
systems. Although LPD might be present on older systems, the majority of the
LPD commands are now also supported when using CUPS. The following table
describes commands associated with LPD and CUPS:

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>lpr</b> </td> <td>Send a job to the print queue (putting print
jobs into the queue is called <i>spooling</i>). Common <b>lpr</b> options
include:

<ul>

<li><b>-#<i>n</i></b> prints <i>n</i> number of copies.

</li>

<li><b>-h</b> prints without using a banner page.

</li>

<li><b>-P </b><i> printer</i> prints to the named printer.

</li>

<li><b>-r</b> removes the job from the queue after printing.

</li>

<li> <b>-w</b> sets the page width of a printable document.

</li>

</ul></td> <td><b>lpr mydoc</b> prints the <i>mydoc</i> file to the default
queue.  
<b>lpr -P printer7 mydoc</b> sends the print job to the <i> printer7's</i>
print queue.  
<b>lpr -#33 mydoc</b> prints 33 copies of the prospectus file.</td>

</tr>

<tr> <td><b>lpc</b></td> <td>View and manage printers and print queues.
Subcommands for <b>lpc</b> include:

<ul>

<li><b>status</b> shows the current state of a printer.

</li>

<li><b>clean</b> removes all files from a print queue.

</li>

<li><b>restart</b> attempts to restart a printer daemon for a printer.

</li>

</ul> </td> <td><b>lpc status printer7</b> displays the current state of
<i>printer7</i>.  
<b>lpc clean all</b> empties the print queues for all printers.</td>

</tr>

<tr> <td><b>lpq</b> </td> <td>Query a print queue. This command displays job
numbers and users who own the print jobs. Specify a user name or a job number
to see information about specific print jobs or print jobs for a specific
user. Common <b>lpq</b> options include:

<ul>

<li><b>-a</b> shows the contents of all queues.

</li>

<li><b>-l</b> gives a verbose (long) listing.

</li>

<li><b>-P</b><i> </i>specifies a specific printer's queue.

</li>

<li><b>-U</b> specifies an alternative username.

</li>

</ul></td> <td><b>lpq -P Printer7</b> shows all print jobs and print job
numbers for printer7.  
<b>lpq -l tjones 56</b> shows a long listing of user tjones' job number
56.</td>

</tr>

<tr> <td><b>lprm</b></td> <td>Remove jobs from the print queue. If executed by
a regular user, the command removes only that user's jobs; if executed by the
superuser, the command removes all print jobs.

<ul>

<li><b>-P</b> specifies a printer name.

</li>

<li><b>-U</b> specifies an alternative username.

</li>

</ul> </td> <td><b>lprm -P printer7 6</b> removes job number 6 from the print
queue of printer7.  
<b>lprm -</b> removes all jobs from the default printer.  
<b>lprm</b> removes the current job from the default printer.</td>

</tr>

<tr> <td><b>lpstat</b></td> <td>See the status of a printer. Options include:

<ul>

<li><b>-t</b> shows all information for all printers on the network.

</li>

<li><b>-u</b> specifies a alternative username.

</li>

</ul> </td> <td><b>lpstat -t shows</b> all information for all printers on the
network.  
<b>lpstat -t printer7</b> shows all information for <i>printer7</i>.  
<b>lpstat -t -u jsmith</b> shows all information for all print jobs on the
network for the user <i>jsmith</i>.</td>

</tr>

<tr> <td><b>cancel</b></td> <td>Cancel print jobs. Options include:

<ul>

<li><b>-P</b> specifies a printer.

</li>

<li><b>-U </b>specifies a alternative username.

</li>

</ul> </td> <td><b>cancel 11</b> cancels print job 11 on the default printer.  
<b>cancel -P printer7 11</b> cancels print job 11 on <i>printer7</i>.  
<b>cancel -P printer7 -U jsmith</b> cancels all print jobs for the user <i>
jsmith</i> on <i>printer7</i>.</td>

</tr>

<tr> <td><b>lpoptions</b></td> <td>Set the default printer. Options include:

<ul>

<li><b>-p</b> specifies the default printer for all users.

</li>

<li><b>-l</b> displays current option settings for a printer.

</li>

</ul>

<b>Note:</b> Users can use the <b>~/.lpoptions</b> file to set their own
default printer values. Include the single line <b>default</b> <i>
printer_name</i> to specify the default printer.

</td> <td>l<b>poptions -p printer7</b> specifies <i>printer7</i> as the
default printer for all users.  
<b>lpoptions -l printer7</b> displays the current option settings for
<i>printer7</i>.</td>

</tr>

<tr> <td><b>accept</b></td> <td>Enable a printer's print queue.</td>
<td><b>accept printer7</b> enables the print queue for <i>printer7</i>.</td>

</tr>

<tr> <td><b>reject</b></td> <td>Disable a printer's print queue.  
<b>Note</b>: This does not clear the print queue.</td> <td><b>reject
printer7</b> disables the print queue for <i>printer7</i>.</td>

</tr>

<tr> <td><b>disable  
cupsdisable</b></td> <td>Keep a printer from printing. Jobs are still added to
the queue, and are printed when the printer is re-enabled.</td> <td><b>disable
printer7</b> keeps <i>printer7</i> from printing the jobs in its queue.</td>

</tr>

<tr> <td><b>enable  
cupsenable</b></td> <td>Activate a disabled printer.</td> <td><b>enable
printer7 </b>activates <i>printer7</i> and allows it to print jobs in its
queue.</td>

</tr> </table>

When using LPD, the configuration file is located at **/etc/lpd.perms**. The
table below describes parameters commonly found in the **/etc/lpd.perms**
file:

<table>

<tr> <td>Parameter</td> <td><b>Description</b></td>

</tr>

<tr> <td>DEFAULT</td> <td>Use the default setting, which is often accept but
can also be set to reject.</td>

</tr>

<tr> <td>HOST</td> <td>The host named in the print job.</td>

</tr>

<tr> <td>REMOTEHOST</td> <td>The host making the request.</td>

</tr>

<tr> <td>REMOTEIP</td> <td>The IP address and subnet mask of the host making
the request.</td>

</tr>

<tr> <td>REMOTEUSER</td> <td>The user making the request.</td>

</tr>

<tr> <td>SAMEHOST</td> <td>The HOST and REMOTEHOST are the same.</td>

</tr>

<tr> <td>SAMEUSER</td> <td>The USER and REMOTEUSER are the same.</td>

</tr>

<tr> <td>SERVER</td> <td>The request originates on the LPD server itself.</td>

</tr>

<tr> <td>SERVICE</td> <td>The SERVICE keyword accepts the following arguments:

<ul>

<li>C=lpc control request

</li>

<li>M=lprm removal request

</li>

<li>P=job printing

</li>

<li>Q=lpq status request

</li>

<li> R=lpr job transfer

</li>

<li>S=lpc status request

</li>

<li>X=connection request

</li>

</ul></td>

</tr>

<tr> <td>USER</td> <td>The user named in the print job.</td>

</tr> </table>

