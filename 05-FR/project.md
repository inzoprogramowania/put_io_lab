# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.

## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję

* [UC3](#uc3): Zakończenie aukcji

* [UC4](#uc4): Płatność

* [UC5](#uc5): Wysłanie zamównienia 

[Kupujący](#ac2)
* [UC2](#uc2): Złożenie nowej oferty

* [UC3](#uc3): Zakończenie aukcji

* [UC4](#uc4): Płatność

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie nowej oferty

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) składa ofertę za przedmiot.
2. Zostaje ona zaakceptowana i jest wyświetlana na stronie jako obecna najlepsza cena ([BR1](#br1)).
3. [Sprzedający](#ac1) zostaje ponformowany o nowej ofercie

**Scenariusze alternatywne:** 

1.A. Podana oferta nie jest wyższa od obecnej najlepszej o mniej niż 1 PLN .
* 1.A.1. System zachęca [Kupujący](#ac2) do podania poprawnej oferty.
* 1.A.2. Przejdź do kroku 1.

---

<a id="uc3"></a>
### UC3: Zakończenie aukcji

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. System blokuje możliwość składania nowych ofert.
2. [Kupujący](#ac2) jest inforowany o wygraniu aukcji. ([BR2](#br2))
3. [Sprzedający](#ac1) jest informowany o ostatecznej cenie sprzedaży.
4. Pozostali [Kupujący](#ac2) są informowani o przegraniu aukcji.

---

<a id="uc4"></a>
### UC4: Płatność

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wybiera sposób oraz adres do dostawy
2. [Kupujący](#ac2) w terminie 7 dni opłaca zakupiony przedmiot ([BR3](#br3)).
3. [Sprzedający](#ac1) potwierdza w ciągu 7 dni ([BR4](#br4)) otrzymanie płatności

**Scenariusze alternatywne:** 

1.A. [Kupujący](#ac2) nie może dokonać płatności w wybrany sposó.
* 1.A.1. [Kupujący](#ac2) zmienia sposób płatności
* 1.A.2 Przejdź do kroku 1.

2.A. [Sprzedający](#ac1) nie potwierdził w ciągu 7 dni otrzymania płatności.
* 2.A.1. Organizator aukcji sprawdza stan płatności.

---

<a id="uc5"></a>
### UC5: Wysłanie zamównienia

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Scenariusz główny:**
1. [Sprzedający](#ac1) w terminie 3 dni od otrzymanai płatności wysyła przedmiot ([BR5](#br5)).
2. [Kupujący](#ac2) odbiera przedmiot.
3. [Kupujący](#ac2) potwierdza stan oraz poprawność przedmiotu ([BR6](#br6)).

**Scenariusze alternatywne:** 

1.A. [Sprzedający](#ac1) nie wysłał przedmiotu w ciągu 3 dni.
* 1.A.1. Termin zostaje przedłużony do 7 dni, od kwoty zostaje pobrana kara.
* 1.A.2. Jeżeli [Sprzedający](#ac1) nadal nie wysłał przedmiotu płatność zostaje zwrócona [Kupujący](#ac2).

2.A. [Kupujący](#ac2) nie potwierdził odebrania przedmiotu.
* 2.A.1. Aukcja zostaje uznana za zakończoną.

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

### BO3: System płatności
Zewnętrzny lub wewnętrzny system umożliwiający niefizyczne przekazanie płatności pomiędzy stronami.

### BO4: System dostaw
Zewnętrzny system umożliwiający przekazanie przedmiotu aukcji pomiędzy stronami.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br3"></a>
### BR3: Dokonanie płatności
Dokonanie płatnści w ciągu 7 dni.

<a id="br4"></a>
### BR4: Potwierdzenie otrzymania płatności
Potwierdznie otrzymania płatnści w ciągu 7 dni.

<a id="br5"></a>
### BR5: Wysłanie przedmiotu 
Wysłanie przedmiotu w ciągu 3 dni od otrzymania płatności.

<a id="br6"></a>
### BR6: Potwierdzenie otrzymania przesyłki
Potwierdznie otrzymania przesyłki w ciągu 24 godzin od jej otrzymania.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt | ... |
| ------------------------------------------------- | ------ | ------- | --- |
| UC1: Wystawienia produktu na aukcję               |    C   |    C    | ... |
| ???                                               |  ...   |  ...    | ... |

