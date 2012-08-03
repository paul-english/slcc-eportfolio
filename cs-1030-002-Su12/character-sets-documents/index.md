---
layout: default
title: Character Set Documents
---

I've had to deal with character type encoding and basic internationalization once before, and at the time all I really needed to worry about was making sure that when we saved any data to our database I prepended the string literal with an `N` to represent unicode. This was MS SQL Server 2008, and the rest of our stack was all automatically running in unicode. We only used utf8, in that case, and I won't talk about the absurd technical debt in the rest of the system, but needless to say character encoding was one of the least of our worries.

As I read through Joel's article there were quite a few new things I picked up. The abstraction that unicode provides us between a character and an encoding makes a lot of sense, and logically is needed to allow easier transitions between different language encodings. It was also interesting to realize how to properly use the meta Content-Type tag within an html document, which was something I usually just cargo-cult added that tag to any documents I happened to write. I never once thought of the importance of including it first in the head, and that in some cases you can avoid the tag altogether using the HTTP Content-Type header.

It's funny that at least one version of IE behaved by trying to guess character encoding if it's not included in headers or in a meta tag. I don't know if more recent versions of IE still behave, but I'm sure it's always better to include a default Content-Type in any html templates I write.

Postel's Law and the Robustness Principle were enlightening on their own. There have been many cases when I've luckily followed that principle without knowing what it was, good thing. I guess after a certain amount of time attempting to integrate with API's or in attempting to import data from some system, you learn to follow that practice a bit instinctual. Unless your a developer on IE of course.

Needless to say, by understanding the fundamentals of modern character encoding it will help to avoid a whole mess of unique bugs that could crop up. Now, time to figure out how to deal with dates, timezones, localized templates, territories, and all the other things that go along with an international application.

## Article References

* [The Absolute Minimum Every Software Developer Absolutely, Positively Must Know About Unicode and Character Sets (No Excuses!)](http://www.joelonsoftware.com/articles/Unicode.html)
* [Robustness Principle](http://en.wikipedia.org/wiki/Robustness_principle)