# Tema 1 - Blackboard pattern

### Enunt
Se considera un program care simuleaza activitatea unei fabrici de mobila

Fabrica are muncitori cu urmatoarele specializari:
- C = Cut seat
- F = Assemble feet
- B = Assemble backrest
- S = Assemble stabilizer bar
- P = Package chair

Procesul tehnologic impune urmatoarele restrictii: asamblarea picioarelor si a spatarului se pot face doar dupa ce a fost decupat sezutul, asamblarea barei se poate face doar dupa ce s-au pus picioarele, iar impachetarea dupa ce e gata asamblat scaunul. Fiecare faza a procesului tehnologic dureaza un timp diferit, influentata de complexitatea operatiei pe care o implica si de priceperea muncitorului care o executa.

Fabrica de mobila din scenariul de mai sus se confrunta cu 2 probleme suplimentare:
- Diversificarea usoara a productiei - folosind aceleasi subansamble, fabrica poate produce in acelasi timp mai multe variante de scaune: scaune fara spatar, scaun fara bara de protectie.
- Inlaturarea punctelor de bottleneck - utilizarea de mai multi muncitori pentru operatiile cu durata mai lunga

In stil Blackboard, se pot folosi 6 muncitori, ca in exemplul: Ion:C, Vasile:F, Viorel:F, Petru:B, Gheo:S, Costi:P.
Toti muncitorii stau in jurul aceleiasi mese rotunde (blackboard) pe care se gasesc scaunele neterminate. Fiecare muncitor stie, examinand un scaun neterminat din blackboard, daca ar fi momentul sa intervina asupra lui.

Dezavantajul acestei solutii este ca muncitorii pierd mult timp examinand continutul blackboard-ului in asteptarea/cautarea unui scaun neterminat asupra caruia pot sa lucreze.

**Link** - **_http://staff.cs.upt.ro/~ioana/arhit/2017/t1.html_**
