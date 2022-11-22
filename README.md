# storage_of_the_alliance

Nyt harjoitustyöni lopputulos, storageoftheallianceaws, eli 'Liittouman varasto'
on käynnissä AWS-pilvessä. Sovelluksen jakeluun käytin AWS:n Elastic Beanstalk-
palvelua. AWS-pilvessä on myöskin AWS:n RDS-palvelun avulla perustettu MariaDB-
tietokanta, jonka kanssa sovellukseni kommunikoi. Oli myös hauskaa ja hyödyllistä
opetella DBeaver:in käyttöä, jonka avulla pystyy muokkaamaan jopa sovelluksen
käyttämää pilvessä olevaa tietokantaa.

Työni palautus viivästyi viimeiseen viikkoon asti, koska halusin tehdä kaiken sen,
mitä olin suunnitellutkin, oppimisen takia, ja koska suhtaudun ohjelmointiin melko
intohimoisesti, sekä myös siksi, että sovellus tulee meillä kotona käyttöön, ja
tulee korvaamaan meillä tällä hetkellä käytössä olevan vanhan java-swing:iä ja
sqlite:ä hyödyntävän sovellukseni.

Frontend-puolella hyödynsin Digitaalisten palvelujen kurssilla tekemääni sivustoa,
jonka tosin jouduin/sain refaktoroida lähdes kokonaan uusisksi. Myöskin ohjelmistoprojekti 1,
jota olen tehnyt samaan aikaan tämän kurssin kanssa, on tukenut oppimistani hyvin.

Harjoitustyön vaatimuksia olen koittanut täyttää myös esim. siten, että on kaksi käyttäjää:
Miisa (vaimoni), admin ja Jussi (minä), user. User-käyttäjän on ainoastaan mahdollista
tarkastella varastotietoja, mutta ei muuttaa, poistaa, eikä lisätä mitään, kuten admin-
käyttäjän taasen on. Sovellus myös tervehtii onnistuneesti kirjautunutta käyttäjää.
Olen toteuttanut rest-ideaa siten, että backend-puolen rest-kotrollereissa on vain kaksi
endpoint:ia: '/containers' ja '/items', ja näitä sitten lähestytään GET-, POST-, PUT-
ja DELETE-tyyppisillä metodeilla, tarpeen mukaan. Spring securityä myöskin hyödynnetään
ja myös jonkin verran thymeleaf:ia. Säilöjen (container) ja esineiden (item) välillä
on oneToMany-suhde. Yksikkötestausta on myös toteutettu jonkin verran.

Backend:in ja frontend:in välinen kommunikaatio hoidetaan DTO-objektien avulla. DTO:ta
myös hyödynnetään silloin kun aiheutuu DatabaseIntegrity-tyyppinen poikkeus, jos
yritetään lisätä kaksi samannimistä säilöä. Käyttäjän syötteen validoinnin olen myös
hoitanut DTO-tasolla, jolloin vääränlaisen syötteen kohdalla DTO:n mukana palautetaan
viesti käytttäjällle. Käyttäjän tervehtimiseen, validointiin ja poikkeusten käsittelyyn
liittyvien viestien näyttäminen hoidetaan javaScript:in alert-funktiota hyödyntäen.
Tein myös luokan 'fromLiteToMaria' (with love, perhaps :-#)# jonka avulla vanhan sqlite-
tietokantatiedostomme tiedot voidaan siirtää CommandLineRunnerissa MariaDB-tietokantaan.
Myöskin tärkeä asiakkaan (eli vaimon) toivomuksen mukainen uudistus frontend-puolella
on se, että säilöjen tilaa-/ei tilaa- ja esineiden poissa-/säilössä-statusta voidaan
muuttaa yhdellä klikkauksella, jolloin asia päivittyy heti myös tietokantaan. Tämä
on tosin mahdollista vain admin-käyttäjälle, ei minulle.

MariaDB:n schema:

CREATE TABLE container (cid BIGINT AUTO_INCREMENT, name TEXT UNIQUE, space_left BOOLEAN, PRIMARY KEY(cid));

CREATE TABLE item (iid BIGINT AUTO_INCREMENT, name TEXT, removed BOOLEAN, cid BIGINT, PRIMARY KEY (iid), FOREIGN KEY (cid) REFERENCES container (cid));

CREATE TABLE app_user (uid BIGINT AUTO_INCREMENT, username TEXT UNIQUE NOT NULL, passwd TEXT NOT NULL, rol TEXT NOT NULL, PRIMARY KEY(uid));
