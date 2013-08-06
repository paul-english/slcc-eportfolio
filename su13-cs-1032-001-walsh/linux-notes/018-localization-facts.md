---
layout: page
title:  Localization Facts
---

A _locale_ is a set of files that Linux uses to determine country and
language-specific settings for various applications. Locales:

  * Determine the way data displays on a computer. This includes: 

    * The language and encoding of the text displayed on screen
    * Character classes
    * Sort order
    * Number formatting
    * Currency type and format
    * Date and time display
  * Use configuration files that are part of the system library and are located in **/usr/share/locale** on most distributions. 
  * Use language codes specified in ISO-639, and county codes specified in ISO-3166.
  * Use the following command format: _Language_territory.codset modifier_. Examples of locale codes with modifiers include **en_GB.UTF-8** and **de_DE.euro**.

Environment variables implement the locale codes. For example **
LANG=en_US.UTF-8** specifies that the computer uses US English with a UTF-8
encoding when displaying information. The following table lists the
configurable environment variables.

<table>

<tr> <td><b>Variable name</b></td> <td><b>Explanation</b></td>

</tr>

<tr> <td>LANG</td> <td>LANG defines all locale settings at once, while
allowing further individual customization via the LC_* settings below. When
LANG=C, programs display output without passing it through locale
translations. This is helpful when the output is being corrupted by the
locale, and will help avoid some types of problems, such as when using
pipelines and scripts that pass on a program's data to another program in
binary form.  
<b>Note</b>: Localization support is the responsibility of the program's
author. Many programs only support one language or a small subset of
languages.</td>

</tr>

<tr> <td>LC_CTYPE</td> <td>LC_CTYPE defines the character handling properties
for the computer. This determines whether characters are recognized as
alphabetical, numeric and so on. This also determines the character set used,
if applicable. </td>

</tr>

<tr> <td>LC_MESSAGES</td> <td>LC_MESSAGES specifies localizations for
applications that use a message-based localization scheme. </td>

</tr>

<tr> <td>LC_COLLATE</td> <td>LC_COLLATE defines the alphabetical ordering of
strings, such as the output of sorted directory listings. </td>

</tr>

<tr> <td>LC_NUMERIC</td> <td>LC_NUMERIC defines formatting for numeric values
that are not monetary. It affects things such as the thousands separator and
the decimal separator. </td>

</tr>

<tr> <td>LC_MONETARY</td> <td>LC_MONETARY defines currency units and
formatting of currency type and numeric values.</td>

</tr>

<tr> <td>LC_TIME</td> <td>LC_TIME defines formatting for dates and times.</td>

</tr>

<tr> <td>LC_PAPER</td> <td>LC_PAPER defines the default paper size.</td>

</tr>

<tr> <td>LC_NAME</td> <td>LC_NAME specifies personal name format. This
includes things like whether the surname comes first or last.</td>

</tr>

<tr> <td>LC_ADDRESS</td> <td>LC_ADDRESS is used for address formatting.</td>

</tr>

<tr> <td>LC_TELEPHONE</td> <td>LC_TELEPHONE defines telephone number
format.</td>

</tr>

<tr> <td>LC_MEASUREMENT</td> <td>LC_MEASUREMENT determines what measurement
units are used.</td>

</tr>

<tr> <td>LANGUAGE</td> <td>LANGUAGE is used as an override for
LC_MESSAGES.</td>

</tr>

<tr> <td>LC_ALL</td> <td>LC_ALL is a special variable for overriding all other
settings. It sets all locales to the same setting.</td>

</tr> </table>

The following table lists and describes the command and options to configure
locale settings:

<table>

<tr> <td>Use...</td> <td>To...</td>

</tr>

<tr> <td><b>locale</b></td> <td> Display the current locale settings for the
computer. Be aware of the following options:

<ul>

<li><b>charmap</b> displays the character encoding.

</li>

<li><b>-a</b> lists all installed locales.

</li>

<li><b>-m</b> lists all installed character encoding options.

</li>

</ul> </td>

</tr>

<tr> <td><b>iconv</b></td> <td> Convert encoding from one encoding type to
another. Be aware of the following options:

<ul>

<li><b>-f</b> specifies the old encoding type.

</li>

<li><b>-t</b> specifies the new encoding type.

</li>

<li><b>-o</b> specifies the input and output file.

</li>

</ul> </td>

</tr> </table>

