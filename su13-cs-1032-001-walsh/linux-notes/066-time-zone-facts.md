---
layout: page
title:  Time Zone Facts
---

A _time zone_ is a geographic region of the world that has the same standard
time. Be aware of the following details:

  * The time zone ensures that daylight hours fall between certain hours, regardless of the area of the world. 
  * In many areas, daylight savings time (DST) moves clocks ahead by one hour from the standard time zone time during "summer" when there are more daylight hours. Not all locations observe daylight savings time. For example, areas along the equator typically do not because the number of daylight hours does not vary significantly throughout the year. 
  * The _local time_ is the time used in your physical location, adjusting for the time zone and daylight savings time (if used). 
  * As you change your physical location, the local time can also change based on the time zone used in that area. 
  * Time zone names used in the United States (Eastern, Central, Mountain, Pacific) are not part of the official time zone standards, but are useful in comparing time between different parts of the country. In the United States, the time zone names can also reflect whether or not daylight time is in effect. 
    * Eastern Daylight Time (EDT) identifies the Eastern time zone, observing daylight standard time. 
    * Mountain Standard Time (MST) identifies the Mountain time zone, not observing daylight standard time. 

Linux computers have two clocks. The following table describes them.

<table>

<tr> <td>Clock</td> <td>Description</td>

</tr>

<tr> <td>Hardware clock</td> <td>The <i>hardware clock</i> is a clock that is
maintained by hardware.

<ul>

<li>The hardware clock runs independently of any program. The clock does not
require the CPU or memory to run.

</li>

<li>Soft power from the power supply and the CMOS battery ensures that the
clock continues to run even when the computer is turned off.

</li>

<li>The hardware clock is sometimes called the real time clock (RTC), BIOS
clock, CMOS clock, or time of year (TOY) clock.

</li>

<li>The current hardware clock time is stored in the <b> /proc/driver/rtc</b>
file.

</li>

</ul> </td>

</tr>

<tr> <td>System time</td> <td><i>System time</i> is the clock that runs within
the operating system.

<ul>

<li>A system clock increments in seconds starting from 12:00 AM on Jan 1,
1970.

</li>

<li>By default, when the computer boots, it sets the system time based on the
hardware clock.

</li>

<li>After the operating system runs, the system time is the only clock used by
applications and services.

</li>

<li>Changing the system time does not automatically change the hardware clock,
although you can change the system time and change the hardware clock to
match.

</li>

<li>The system clock is the clock that Linux uses for all its functions and
applications.

</li>

</ul> </td>

</tr> </table>

Clocks on a Linux computer can use local time or UTC time. The following table
describes these and explains how to calculate a UTC offset.

<table>

<tr> <td>Time</td> <td>Description</td>

</tr>

<tr> <td>Coordinated Universal Time (UTC)</td> <td>Coordinated Universal Time
(UTC), formerly known as Greenwich Mean Time (GMT), is a method of identifying
a common time between devices regardless of their physical location in the
world.

<ul>

<li>UTC is adjusted periodically to match the rotation of the earth by adding
<i>leap seconds</i>. Leap seconds are required because the official duration
of a second does not exactly match the earth's rotation (but is very close).

</li>

<li>UTC matches time to the rotation of the earth using a single fixed point
in Greenwich, England. A line drawn from north pole to south pole that passes
through Greenwich is called the <i>prime meridian</i>.

</li>

<li>Most computers use UTC (not local time) when recording timestamps. This
ensures that a single method of keeping time is used, regardless of the
physical location of the computer.

</li>

<li>Time expressed using UTC is identified by adding UTC or Z to the time. For
example, 09:30 UTC is the same as 09:30Z or 0930Z. UTC is also called Zulu
time.

</li>

</ul></td>

</tr>

<tr> <td>UTC offset</td> <td>The <i>UTC offset</i> identifies the amount of
time that local time is ahead of or behind Coordinated Universal Time (UTC).

<ul>

<li>Local time in each time zone is identified by the UTC offset. For example:

<ul>

<li>Time zones used in the United States are UTC-05 (Eastern), UTC-06
(Central), UTC-07 (Mountain), and UTC-08 (Pacific), with time being behind
UTC.

</li>

<li>Time zones used in Europe and Asia are ahead of UTC. For example, time in
Germany is UTC+01, and time in Japan is UTC+09.

</li>

</ul>

</li>

<li>To convert UTC to local time, add time based on the UTC offset (UTC +
offset). For example, if UTC is 06:00:

<ul>

<li>Local time in New York (UTC-05) would be 01:00 (06:00 + - 5:00 = 1 am).

</li>

<li>Local time in Los Angeles (UTC-08) would be 22:00 the previous day (10
pm).

</li>

<li>Local time in Japan (UTC+09) would be 15:00 (3 pm).

</li>

</ul>

</li>

<li>To convert local time to UTC, subtract time based on the UTC offset (UTC -
offset). For example:

<ul>

<li>If the local time in New York (UTC-05) is 14:00, UTC is 19:00 (14:00 - -
5:00 = 14:00 \+ 5:00).

</li>

<li>If the local time in Japan (UTC+09) is 14:00, UTC is 5:00 (14:00 - +
9:00).

</li>

</ul>

</li>

<li>UTC does not change for daylight savings time; however, the offset used by
a time zone will change. During daylight savings time, add one hour to the UTC
offset. For example:

<ul>

<li>Standard time in New York is UTC-05; daylight time in New York is UTC-04.

</li>

<li>Standard time in Germany is UTC+01; daylight time in Germany is UTC+02.

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Local time</td> <td>Local time is the current time in a local time
zone. It is designated using the number of hours ahead or behind UTC time. For
example the local time for the Mountain Time Zone in the United States is UTC
-7. The default setting for several hardware clocks in a system BIOS is often
local time.</td>

</tr> </table>

The following table describes the tools and files used to determine and change
time zone settings.

<table>

<tr> <td><b>Use...</b></td> <td><b>To...</b></td> <td><b>Examples</b></td>

</tr>

<tr> <td><b>/usr/share/zoneinfo</b></td> <td>View the set of time zone
configuration files and directories, with each file identifying a specific
time zone.

<ul>

<li>Files are typically organized in subfolders based on continent (such as
Australia) or major country (such as US).

</li>

<li>Individual files identify a major city in the time zone (such as Perth) or
a specific region (either a division of the country or a country within the
continent).

</li>

<li>Information in the file identifies the UTC offset and any rules for
daylight savings time.

</li>

<li>Depending on the distribution, time zone files might be located at
<b>/usr/lib/zoneinfo</b>.

</li>

</ul></td><td><b>ls /usr/share/zoneinfo </b>displays the names for time zones
that Linux uses. Additional settings are located in the subdirectories.</td>

</tr>

<tr> <td><b>/etc/localtime</b></td> <td>See the current time zone and change
the time zone. The <b>/etc/localtime</b> file identifies the current time zone
file used on the system. This is a symbolic link to a timezone file in the
<b>/usr/share/zoneinfo</b> directory. Replacing this link changes the
timezone.</td> <td><b>ln -s /usr/share/zoneinfo/</b><i>time_zone_file</i><b>
/etc/localtime </b> creates a symbolic link to the time zone file that
permanently alters the time zone for the current user account.  
<b>cp -s /usr/share/zoneinfo/</b><i>time_zone_file</i><b> /etc/localtime </b>
accomplishes the same result as the example above.</td>

</tr>

<tr> <td><b>/etc/timezone</b></td> <td>See the time zone settings on Debian
computers<b>. /etc/timezone</b> identifies the current time zone by region and
zone. </td> <td> </td>

</tr>

<tr> <td> <b> /etc/sysconfig/clock</b></td> <td>

See the current time zone. The file shows the following line:

<ul>

<li>ZONE=<i>timezone</i>

</li>

</ul> </td> <td> <b> cat /etc/sysconfig/clock  
ZONE="America/Denver"</b></td>

</tr>

<tr> <td><b>date</b></td> <td>To view and manually set the system time. </td>
<td><b>date</b> shows the current local time and the time zone.</td>

</tr>

<tr> <td><b>tzselect</b></td> <td>Change the value of the time zone (TZ)
environment variable.

<ul>

<li>When executed, the utility prompts you to select a region, then a country,
and so on until it has enough information to determine the time zone.

</li>

<li>Only the root user can invoke the tzselect utility.

</li>

</ul>

<b>Note</b>: Use the <b>tzconfig</b> command on Debian Linux distributions in
place of <b>tzselect</b>.

</td> <td>To use <b>tzselect</b>:

<ol>

<li>Type <b>tzselect</b> and press Enter.

</li>

<li>Type the number from the list that corresponds to the correct continent or
ocean, and press Enter.

</li>

<li>Type the number from the list that corresponds to the correct region, and
press Enter.

</li>

<li>Type the number from the list that corresponds to the correct timezone,
and press Enter.

</li>

<li>Press 1 to confirm the setting.

</li>

</ol> </td>

</tr>

<tr> <td><b> TZ=<i>time_zone</i>  
export TZ</b></td> <td>Change the time zone environment variable. Use the file
names in the<b> /usr/share/zoneinfo </b>directory to see the appropriate names
for time zones.

<b> Note: </b>Environment variable changes are only permanent if they are
added to a shell configuration file similar to <b>~/.bashrc</b> or
<b>~/bash_profile</b>.

</td> <td><b> TZ=America/Denver  
export TZ</b></td>

</tr> </table>

