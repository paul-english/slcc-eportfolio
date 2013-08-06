---
layout: page
title:  Kernel Option Facts
---

_Kernel options_ allow customization of Linux boot parameters to permit
administrators to fix several problems related to booting. The following table
describes common kernel parameters:

<table>

<tr> <td>Use...</td> <td>To...</td> <td><b>Examples</b></td>

</tr>

<tr> <td><i>runlevel_number</i></td> <td> Boot into a specific runlevel. </td>
<td><i>kernel_parameters</i> <b>3 </b>starts the computer in runlevel three.
</td>

</tr>

<tr> <td><b>vga</b></td> <td> Change monitor display settings.</td>
<td><b>vga=0x307</b> sets the monitor resolution to 1280x1024 with 256 colors.
</td>

</tr>

<tr> <td><b>init</b></td> <td>Change the program that the kernel starts at
boot time.</td> <td><b>init=/bin/bash </b>starts the bash shell at boot
time.</td>

</tr>

<tr> <td><b>acpi</b></td> <td>Enable or disable the advanced configuration and
power interface (ACPI).</td> <td><b>acpi=off</b> disables ACPI.</td>

</tr>

<tr> <td><b>apm</b></td> <td>Enable or disable advanced power management
(APM).</td><td><b>apm=off</b> disables APM.</td>

</tr> </table>

To add kernel options while the GRUB menu is displayed:

  * Use the following sequence to insert the options directly into the existing boot options:
    1. Select the operating system.
    2. Press the **a** key. 
    3. Add the kernel boot options to the existing boot options.
  * Use the following sequence to add the options to the options listed in the** /boot/grub/grub.conf** file:
    1. Select the operating system.
    2. Press the **e** key. 
    3. Select the kernel line.
    4. Press the **e** key. 
    5. Add the kernel boot options to the existing boot options.

