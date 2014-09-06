Holidays with Java 8
========

Calculate the holidays of a country at runtime. No need to parse some special websites with these dates.


**Supported Counries**
 - Germany
 - Austria

**Sample**

This sample requests every german holiday, filters if it is a national one and sort it ascending.

```java
		Country.GERMANY
				.getHolidays()
				.filter(holiday -> holiday.isNational())
				.sorted((h1, h2) -> h1.getDate(2014)
						.compareTo(h2.getDate(2014)))
				.map(holiday -> holiday.getDate(2014))
				.forEach(System.out::println);
```

The Result:
<pre>Wed Jan 01 15:39:44 CET 2014
Mon Jan 06 15:39:44 CET 2014
Fri Apr 18 15:39:44 CEST 2014
Sun Apr 20 15:39:44 CEST 2014
Mon Apr 21 15:39:44 CEST 2014
Thu May 01 15:39:44 CEST 2014
Thu May 29 15:39:44 CEST 2014
Sun Jun 08 15:39:44 CEST 2014
Mon Jun 09 15:39:44 CEST 2014
Thu Jun 19 15:39:44 CEST 2014
Fri Aug 15 15:39:44 CEST 2014
Fri Oct 03 15:39:44 CEST 2014
Fri Oct 31 15:39:44 CET 2014
Sat Nov 01 15:39:44 CET 2014
Wed Nov 19 15:39:44 CET 2014
Thu Dec 25 15:39:44 CET 2014
Fri Dec 26 15:39:44 CET 2014
Sat Dec 27 15:39:44 CET 2014</pre>

License
=======
Copyright 2014 Fabio Hellmann

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
