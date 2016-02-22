# JEA
<b>DESCRIPTION:</b>

JEA - is a small library, which allows you to recieve information from ereality.ru API's in convenient Java format. 

*Used libraries:*

* Google Gson - https://github.com/google/gson
* Kayahr Pherialize - https://github.com/kayahr/pherialize

At the moment library provides access to next API's:
* Character data;
* Islands exploring status and update timer status
* Islands trade offers and shipload status

<b>USAGE:</b>

Simply call static method `initialize()` in interested data class, use public method's to recieve data. Method `updateData()` updates data respectivly.

<b>EXAMPLES:</b>
```Java
ContrabandistOffer cOffer = ContrabandistOffer.initialize(); // now u have an instance of class
cOffer.getGoodsId(); // returns an id of productm that contrabandist is currently buying
cOffer.updateData(); // checks out new information from game API's
```
<b>List of available data classes:</b>
* Character data:
  - Personage;
* Islands data:
  - MalachiteIsland;
  - TurquoiseIsland;
  - ResoursesUpdateTimer;
* Trades data:
  - GlobalOffers;
  - CharacterOffers;
  - ContrabandistOffer;
  - Shipload;

