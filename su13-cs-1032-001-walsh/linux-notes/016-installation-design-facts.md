---
layout: page
title:  Installation Design Facts
---

Be aware of the following advantages to planning and designing a Linux
installation:

  * A plan ensures that the installer knows exactly what should happen during the installation. The plan places all the information in the installer's hands before installation begins.
  * There are fewer variables involved when diagnosing and resolving problems. 
  * The plan ensures that there is something concrete to reference if managers add requests after the installation begins. It gives the IT team something to use as a point of reference if the changes require a change in resources or schedule. 

The following table describes general steps in an effective installation
design:

<table>

<tr> <td>Step</td> <td>Description</td>

</tr>

<tr> <td>Perform a needs assessment</td> <td> An effective assessment
determines the goals of the installation, creates a plan to meet those needs,
and measures the results of the plan. This involves:

<ul>

<li>Interviewing managers to determine the goals they want to achieve, what
problems they need to solve, the expected results.

</li>

<li>Writing clear, measureable statements that specifically address the goals.

</li>

<li>Indentifying the stake holders.

</li>

<li>Confirming correct authorization.

</li>

<li>Aligning the installation with current organizational strategy and
technology.

</li>

<li>Verifying funding.

</li>

<li>Creating a support strategy.

</li>

<li>Determining the scope:

<ul>

<li>Identify deadlines.

</li>

<li>Determine the tasks that must be completed.

</li>

<li>Plan for human resource allocation.

</li>

</ul>

</li>

</ul></td>

</tr>

<tr> <td>Pick a distribution</td> <td> Picking a distribution involves:

<ul>

<li>Determining whether the computer should be a server or a workstation. Most
distributions can be either, but some are better designed for specific
functions and even specific types of servers. For example:

<ul>

<li>The SUSE Linux Enterprise Server is optimized to be used as a server.

</li>

<li>The SUSE Linux Enterprise Desktop is optimized to be used as a desktop.

</li>

</ul>

</li>

<li>Determining whether end users will be comfortable with the distribution,
or whether configuration changes might be necessary.

</li>

<li>Determining whether required software is available for the distribution.
Make a list of applications and ensure that they are provided on the
distribution.

</li>

<li>Ensuring that the distribution has the necessary support.

</li>

</ul> </td>

</tr>

<tr> <td>Determine the hardware requirements</td> <td>Some computer hardware
is incompatible with some distributions. Ordering hardware without first
ensuring that the operating system can actually be installed can lead to a
stack of useless hardware. Ensure that:

<ul>

<li>The computer's hardware is on the distribution's hardware compatibility
list.

</li>

<li>The computers have sufficient CPU speed, memory and other system
requirements to run the distribution and the installed software.

</li>

<li>The correct version of the distribution is installed on the computer based
on the computer's CPU architecture. These include:

<ul>

<li>x86 for 32 bit CPUs

</li>

<li>x64 for 64 bit CPUs

</li>

<li>IA-64 for Itanium CPUs

</li>

<li>ALPHA for Alpha CPUs

</li>

<li>PPC for Power PC (Apple) CPUs

</li>

</ul>

</li>

</ul> </td>

</tr>

<tr> <td>Plan the file system</td> <td>

The file system determines how a computer's files are organized on a hard
drive. Linux supports several file system types that have different
characteristics, including:

<ul>

<li><i>ext2</i> has volume integrity features that may take several minutes to
run after a system crash.

</li>

<li><i>ext3</i> uses journaling to ensure that only incomplete transactions
are checked after a system crash. It is the default file system on most
distributions.

</li>

<li><i>ReiserFS</i> also uses journaling and also implements additional
security features based on its file structure.

</li>

</ul>

Pick the one that best meets your organization's needs. Considerations
include:

<ul>

<li>Maximum volume size

</li>

<li>Maximum file size

</li>

<li>File name size

</li>

<li>Permissions and file security

</li>

<li>Encryption support

</li>

<li>Recovery support and speed

</li>

<li>Backup support

</li>

<li>Journal support

</li>

</ul> </td>

</tr>

<tr> <td>Plan the partitions</td> <td>

Partition planning is another element of file system planning. An efficient
strategy is to create multiple partitions based on the types of files held on
the partition and the user access needs to the data. Consider creating
separate partitions for the following directories. Set mount options based on
the type of files in the directory.

<ul>

<li><b>/ </b>(root) needs to be at least 4 GB, but should be much larger. The
partition holding the root directory should be on a primary partition and must
be formatted with a Linux filesystem.

</li>

<li><b>/home</b> should be a minimum of 5 - 10 GB, or as large as needed to
store the user files.

</li>

<li><b>/boot</b> should be 100 - 200MB. It needs to be in the first 1024
cylinders of the disk for older BIOS versions.

</li>

<li><b>/opt</b> should be at least 1 GB based on the number of applications
that will be installed.

</li>

<li><b>/tmp </b>should be 1GB. Temporary files are cleaned out by the
operating system periodically.

</li>

<li><b>/usr</b> should be 5 GB - 16 GB. based on the number of installed
packages.

</li>

<li><b>/var</b> should be 3 - 10 GB. Make it large enough that log file size
does not affect the rest of the computer.

</li>

<li><b>/swap </b>should be 1 - 1.5 times larger than the amount of installed
RAM. Linux can use either a swap file or a swap partition for the swap area.
Whenever possible, create a separate swap partition.

</li>

</ul>

<b>/etc</b>, <b>/bin</b>, <b>/sbin</b>, <b>/lib</b>, <b>/dev</b>,<b> </b>
and<b> /proc</b> must all be on the same partition. These directories have
system configuration files that are necessary for Linux to function properly.

</td>

</tr>

<tr> <td>Identify software</td> <td>Determine which software packages need to
be installed, and only install those packages. This ensures that system
resources are conserved, and that vulnerabilities are limited.</td>

</tr>

<tr> <td>Identify the users</td> <td>Determine the users who will use the
computer. Consider the following:

<ul>

<li>Ensure correct name spelling for the users.

</li>

<li>Determine whether users log in locally or over the network.

</li>

<li>Have a list of groups to which the users will belong.

</li>

</ul>

The root user is always installed. Use this account only when necessary to
ensure security.

</td>

</tr>

<tr> <td>Gather network information</td> <td>Gathering network information
includes the following types of information:

<ul>

<li>IP address

</li>

<li>Default gateway

</li>

<li>Subnet mask

</li>

<li>Server information for DNS servers, mail servers, and other network
servers

</li>

<li>Network topology information such as domain names

</li>

<li>Naming conventions for servers and workstations

</li>

<li>Domain names

</li>

</ul> </td>

</tr>

<tr> <td>Select an installation source</td> <td>Installation sources include:

<ul>

<li>CD

</li>

<li>DVD

</li>

<li>Network share

</li>

</ul>

<b>Note:</b> Determine whether to install the distribution locally, or over
the network as well.

</td>

</tr> </table>

