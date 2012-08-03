---
layout: page
title: IP Assignment
---

## Table of Internal Network IP Addresses

    |    IP Address |   Subnet Mask | Default Gateway | Class | Default Subnet Mask | CIDR Notation    |
    |---------------+---------------+-----------------+-------+---------------------+------------------|
    |  192.168.0.14 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.14/24  |
    |  192.168.0.17 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.17/24  |
    |   192.168.0.5 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.5/24   |
    |   192.168.0.3 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.3/24   |
    |   192.168.0.2 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.2/24   |
    |   192.168.0.6 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.6/24   |
    |   192.168.0.4 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.4/24   |
    |   192.168.0.7 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.7/24   |
    | 192.168.0.105 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.105/24 |
    |   192.168.0.8 | 255.255.255.0 |     192.168.0.1 | C     |       255.255.255.0 | 192.168.0.8/24   |

You may need to scroll to view the entire table. In my case OSX hides scrollbars now, which is aesthetically pleasing but slightly breaks with tradition. So it may not be readily obvious for some.

## Public IP Address

* *IP Address:*           144.35.25.242
* *Class:*                B
* *Default Subnet Mask:*  255.255.0.0
* *CIDR Notation:*        144.35.25.242/16

## Reflective Writing

This was pretty easy, log into the router admin, grab the list of attached devices. I haven't split or done anything tricky with my network other than setup one or two static IP addresses, so each gateway & subnet mask were the same. From this point manually classifying, and coming up with the CIDR notation is a quick process.However, I'm a lazy person so I used my cool [IP Address information tool](http://ip-tool.onfrst.com).

I found that coming from a mostly Computer Science perspective that I had a lot to learn about networking. I had no real idea beforehand what it meant to subnet, or supernet. I didn't know what CIDR notation was, and I remember once screwing up the default settings of my VPN software because I lacked this knowledge. Never again will I fubar my internal network due to misinformation, well hopefully...