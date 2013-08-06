---
layout: page
title:  Ntp Facts
---

The Network Time Protocol (NTP) is a method of setting and synchronizing
system time between computers. NTP uses a hierarchy of clocks and computers
for identifying the current Coordinated Universal Time (UTC). NTP:

  * Synchronizes time in increments.
  * Allows computers to be a time consumer and a time provider simultaneously so computers can synchronize hierarchically.
  * Runs on IP port 123.
  * Uses _strata_ to define time providers in a hierarchy (levels of time providers):
    * Stratum 0 devices are accurate clocks (such as atomic clocks) that provide the official UTC. 
    * Stratum 1 devices are attached to the time devices (stratum 0). Stratum 1 devices are referred to as _time servers_ because they provide time to other servers and computers through NTP. 
    * Stratum 2 devices receive their time from stratum 1 devices, and can also provide time to other devices. 
  * Supports up to 256 strata, with lower devices getting time from higher devices and providing time to devices in a lower stratum.
  * Can be configured to use a pool of time servers at **pool.ntp.org**.
  * Uses _stepping _to quickly make large adjustments to close time discrepancies; usually about once every 60 seconds.
  * Uses _slewing_ to make smaller incremental time adjustments at a rate of about every 15 - 17 minutes. Slewing occurs when time discrepancies are under 128ms. 
  * Does not adjust times when time discrepancies are larger than 17 Minutes. This is known as _insane time_.
  * Tracks of the NTP daemon (ntpd) activity in the **/var/log/ntp** log.

Use the following files and utilities to manage time using the NTP:

<table>

<tr> <td>Use...</td> <td>To...</td> <td>Examples</td>

</tr>

<tr> <td> <b>/etc/ntp.conf</b></td> <td>Configure the time providers on the
NTP client.

<ul>

<li>Each entry in the file begins with <b>server</b> and then the address of
the time provider.

</li>

<li>The <b>server 127.127.1.0 </b>represents the local host address and sets
the system time to the hardware clock if no other time providers are
available.

</li>

</ul> </td> <td><b>server 0.fedora.pool.ntp.org</b> synchronizes the time with
the Fedora time server pool.  
<b>server 192.168.1.10</b> synchronizes the time with a computer at the
specified IP address.  
<b>server 127.127.1.0</b> synchronizes the time with the hardware clock on the
local computer.</td>

</tr>

<tr> <td><b>ntpdate</b></td> <td>Update the current time on a computer.
<b>ntpdate</b>:

<ul>

<li>Must be run as root.

</li>

<li>Will not function if <i>ntpd</i> is currently running.

</li>

</ul>

<b>Note</b>: <b>ntpdate</b> is deprecated; Use <b>ntpd</b> in its place.

</td> <td><b>ntpdate 0.pool.ntp.org</b> updates the system time using a time
provider from the NTP pool.</td>

</tr>

<tr> <td><b>ntpd</b></td> <td>Manage the NTP daemon from the command line.
Options include:

<ul>

<li><b>-q </b>does a one-time synchronization with a time provider. It is
similar to <b>ntpdate</b>.

</li>

<li><b>-g</b> allows the NTP daemon to ignore insane time restrictions for the
first synchronization.

</li>

<li><b>-c</b> specifies the name and path of the configuration file. The
default is <b>/etc/ntp.conf</b>.

</li>

</ul> </td> <td><b>ntpd -qg</b> updates the current time on the computer and
ignores insane time restrictions.  
<b>ntpd -c ~/ntp/ntpconfig.txt</b> changes the configuration file that NTP
uses to <i>~/ntp/ntpconfig.txt</i>.</td>

</tr>

<tr> <td><b>rcntp start  
</b>or  
<b>service ntpd start</b></td> <td>Start the NTP daemon.

<b>Note: rcntp </b>only works on BSD operating systems

</td> <td><b>service ntpd start </b>starts the NTP daemon.</td>

</tr>

<tr> <td><b>insserv ntp</b></td> <td>Configure the NTP daemon to start at boot
time (BSD systems only.)</td> <td> </td>

</tr>

<tr> <td><b>ntpq</b></td> <td>Query the status of the NTP daemon. Use<b>
-c</b> to invoke a command. Commands include:

<ul>

<li><b>remote</b> specifies the IP address of the current time provider.

</li>

<li><b>refid</b> Specifies the type of time source the time provider is using.

</li>

<li><b>st</b> shows the stratum of the time provider.

</li>

<li><b>when</b> shows the last synchronization time.

</li>

<li><b>poll</b> shows the synchronization interval.

</li>

<li><b>reach</b> lists the last time NTP queried the time provider.

</li>

<li><b>delay</b> displays the network lag time between the time provider and
the client.

</li>

</ul></td> <td><b>ntpq -c reach</b> shows the last time NTP queried the time
provider. </td>

</tr>

<tr> <td><b>ntptrace</b></td> <td>Display the next stratum up from the time
provider.</td> <td> </td>

</tr> </table>

Keep the following in mind when working with NTP:

  * To see what happens as the NTP daemon starts, use one terminal to start the daemon, and use another terminal with the **tail** command to view the daemon log at **/var/log/ntp**.
  * The time used by the computer is adjusted to account for network delay and other inaccuracies detected in the received time. The amount of error that the algorithm identifies is called the _drift_. The drift is calculated over time and typically saved on the computer to quickly identify accurate time, compensated by the drift amount. 
  * The computer continues to poll the time servers to ensure that the system time remains synchronized. 

