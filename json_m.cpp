#include "json_m.h"
#include <iostream>


using namespace std;
json_m::json_m()
{

}
ListaGladiador json_m::generarlista(json j1){
    ListaGladiador ls;
    for (int i = 0; i <4 ; ++i) {
        cout<<j1["ID"+to_string(i)]<<endl;
        Gladiador *gl = new Gladiador(j1["ID"+to_string(i)],0,0);
        ls.agregar(gl);
    }
    return ls;
}

json json_m::string_json(string s){
    json j1;
    j1 = json::parse(s);
    return j1;

}
string json_string(json j1){
    string s;
    s = j1.dump();
    return s;
}
