package week12;

public class ArvoreBinária {

    static Nó raiz = null;

    public static void main(String[] args) {

        //https://www.devmedia.com.br/trabalhando-com-arvores-binarias-em-java/25749
        insereIterativo(5);
        insereIterativo(2);
        insereIterativo(1);
        insereIterativo(6);
        insereIterativo(7);
        insereIterativo(4);

        //System.out.println(MaiorValor(raiz));
        System.out.println("raiz " + raiz);
        System.out.println("esq " + raiz.esq);
        System.out.println("dir " + raiz.dir);
        System.out.println(raiz.esq.dir);
        RemoveValor(4);



        /*
        insereIterativo(8);
        insereIterativo(3);
        insereIterativo(10);
        insereIterativo(1);
        insereIterativo(6);
        insereIterativo(14);
        insereIterativo(4);
        insereIterativo(7);
        insereIterativo(13);
         */
        //PreExibe(raiz);
        //ExibeOrdenado(raiz);
    }

    public static Nó BuscarValor(Nó temp, int v) {
        if (temp == null) {
            return null;
        }

        if (temp.valor == v) {
            return temp;
        }

        if (v < temp.valor) {
            return BuscarValor(temp.esq, v);
        } else {
            return BuscarValor(temp.dir, v);
        }
    }

    public static int MaiorValor(Nó temp) {
        if (raiz == null) {
            return -1;
        } else {
            if (temp == null) {
                return 0;
            } else {
                if (temp != null && temp.esq == null && temp.dir == null) {
                    return temp.valor;
                } else {
                    int esq = MaiorValor(temp.esq);
                    int dir = MaiorValor(temp.dir);
                    if (esq >= dir) {
                        return esq;
                    } else {
                        return dir;
                    }
                }
            }
        }
    }

    public static void RemoveValor(int v) {
        Nó temp = raiz;
        //Buscar o Valor
        Nó encontrar = BuscarValor(temp, v);
        if (encontrar != null) {
            System.out.println("está na árvore");
        } else {
            System.out.println("Não está na árvore");
        }
    }

    public static void insereIterativo(int v) {
        Nó novo = new Nó(v);

        if (raiz == null) {
            raiz = novo;
        } else {
            boolean inseriu = false;
            Nó temp = raiz;

            while (!inseriu) {
                if (novo.valor <= temp.valor) {
                    if (temp.esq == null) {
                        temp.esq = novo;
                        inseriu = true;
                    } else {
                        temp = temp.esq;
                    }
                } else {
                    if (temp.dir == null) {
                        temp.dir = novo;
                        inseriu = true;
                    } else {
                        temp = temp.dir;
                    }

                }
            }
        }
    }

    public static void PreExibe(Nó temp) {
        if (temp != null) {
            System.out.println(temp.valor);
            PreExibe(temp.esq);
            PreExibe(temp.dir);
        }
    }

    public static void ExibeOrdenado(Nó temp) {
        if (temp != null) {
            ExibeOrdenado(temp.esq);
            System.out.println(temp.valor);
            ExibeOrdenado(temp.dir);
        }
    }

    public static void ExibeInverso(Nó temp) {
        if (temp != null) {
            ExibeInverso(temp.dir);
            System.out.println(temp.valor);
            ExibeInverso(temp.esq);
        }
    }

    public static void Exibe1Filho(Nó temp) {
        if (temp != null) {
            Exibe1Filho(temp.esq);
            Exibe1Filho(temp.dir);

            if ((temp.esq == null && temp.dir != null) || (temp.esq != null && temp.dir == null)) {
                System.out.println(temp.valor);
            }
        }

    }

    public static void ExibeFolhas(Nó temp) {
        if (temp != null) {
            ExibeFolhas(temp.esq);
            ExibeFolhas(temp.dir);

            if (temp.esq == null && temp.dir == null) {
                System.out.println(temp.valor);
            }
        }
    }

    public static void ExibeSubEsq(Nó temp) {
        temp = temp.esq;
        System.out.println(" " + temp.valor);
        if (temp.esq == null && temp.dir == null) {
            System.out.printf(null + " " + null);
        }
        if (temp.esq == null && temp.dir != null) {
            System.out.printf(null + " " + temp.dir.valor);
        }
        if (temp.esq != null && temp.dir == null) {
            System.out.println(temp.dir.valor + " " + null);
        } else {
            System.out.printf(temp.esq.valor + " " + temp.dir.valor);
        }

        System.out.printf("\n");
    }

    public static void ExibeSubDir(Nó temp) {
        temp = temp.dir;
        System.out.println(" " + temp.valor);
        if (temp.esq == null && temp.dir == null) {
            System.out.printf(null + " " + null);
        } else if (temp.esq == null && temp.dir != null) {
            System.out.printf(null + " " + temp.dir.valor);
        } else if (temp.esq != null && temp.dir == null) {
            System.out.println(temp.dir.valor + " " + null);
        } else {
            System.out.printf(temp.esq.valor + " " + temp.dir.valor + "\n");
        }
    }

    public static int contaFolhas(Nó temp) {
        if (temp == null) {
            return 0;
        } else {
            if (temp.esq != null || temp.dir != null) {
                return contaFolhas(temp.esq) + contaFolhas(temp.dir);
            } else {
                if (temp.esq == null && temp.dir == null) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public static int profundidade(Nó temp) {

        if (raiz == null) {
            return -1;

        } else {
            if ((temp == null) || (temp.esq == null && temp.dir == null)) {
                return 0;
            } else {
                int ld = profundidade(temp.dir);
                int le = profundidade(temp.esq);

                if (ld > le) {
                    return ld + 1;
                } else {
                    return le + 1;
                }

            }
        }
    }

}
