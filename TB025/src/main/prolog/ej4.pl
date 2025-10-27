% Base de datos
trenDirecto(saarbruecken, dudweiler).
trenDirecto(forbach, saarbruecken).
trenDirecto(freyming, forbach).
trenDirecto(stAvold, freyming).
trenDirecto(fahlquemont, stAvold).
trenDirecto(metz, fahlquemont).
trenDirecto(nancy, metz).

% Predicado
viajar(Una, Otra) :- trenDirecto(Una, Otra).
viajar(Una, Otra) :-
    trenDirecto(Una, Localidad), viajar(Localidad, Otra).

/*
trace:
Call:viajar(nancy,saarbruecken)
 Call:trenDirecto(nancy,saarbruecken)
 Fail:trenDirecto(nancy,saarbruecken)
 Redo:viajar(nancy,saarbruecken)
 Call:trenDirecto(nancy,_696)
 Exit:trenDirecto(nancy,metz)
 Call:viajar(metz,saarbruecken)
 Call:trenDirecto(metz,saarbruecken)
 Fail:trenDirecto(metz,saarbruecken)
 Redo:viajar(metz,saarbruecken)
 Call:trenDirecto(metz,_698)
 Exit:trenDirecto(metz,fahlquemont)
 Call:viajar(fahlquemont,saarbruecken)
 Call:trenDirecto(fahlquemont,saarbruecken)
 Fail:trenDirecto(fahlquemont,saarbruecken)
 Redo:viajar(fahlquemont,saarbruecken)
 Call:trenDirecto(fahlquemont,_700)
 Exit:trenDirecto(fahlquemont,stAvold)
 Call:viajar(stAvold,saarbruecken)
 Call:trenDirecto(stAvold,saarbruecken)
 Fail:trenDirecto(stAvold,saarbruecken)
 Redo:viajar(stAvold,saarbruecken)
 Call:trenDirecto(stAvold,_702)
 Exit:trenDirecto(stAvold,freyming)
 Call:viajar(freyming,saarbruecken)
 Call:trenDirecto(freyming,saarbruecken)
 Fail:trenDirecto(freyming,saarbruecken)
 Redo:viajar(freyming,saarbruecken)
 Call:trenDirecto(freyming,_704)
 Exit:trenDirecto(freyming,forbach)
 Call:viajar(forbach,saarbruecken)
 Call:trenDirecto(forbach,saarbruecken)
 Exit:trenDirecto(forbach,saarbruecken)
 Exit:viajar(forbach,saarbruecken)
 Exit:viajar(freyming,saarbruecken)
 Exit:viajar(stAvold,saarbruecken)
 Exit:viajar(fahlquemont,saarbruecken)
 Exit:viajar(metz,saarbruecken)
 Exit:viajar(nancy,saarbruecken)
 true
 */