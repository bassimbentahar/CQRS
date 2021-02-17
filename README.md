# CQRS

L’objectif est d’exploiter le pattern CQRS qui permet de séparer les services qui mettent à jour une BD de ceux qui permettent de lire son contenu.
Le domaine est celui des films que l’on peut enregistrer et consulter. 
Le système que nous voulons implémenter contient donc une partie « writer » et une partie « reader ».

Lorsqu’on veut enregistrer un nouveau film dans la base de données « master » on invoque le writer. Mais pour pouvoir lire les titres des films, 
opération supposée plus fréquente, nous voulons disposer de readers rapides. Ainsi lorsqu’un nouveau film est
enregistré, nous devons propager l’information pertinente aux readers pour qu’ils la stockent dans leur structure de stockage. Le writer va donc s’adresser au PubSubHub pour propager l’information. Ce dernier enverra ensuite l’évènement aux readers qui ont
souscrit à l’évènement (topic).

Les étapes de l’usage des services sont donc :
1) Enregistrer les readers comme subscribers des évènements de topic « film »
2) Stocker des films dans la base du writer. Les readers seront donc informés
immédiatement via le pubsubhub
3) Lire un film via un readers. Ce dernier va donc puiser dans sa propre structure de
données
L’application est implémentée par les web services suivants sur Tomcat :
• CQRSFilmsWriter
• PubSubHubService
• CQRSReader
• CQRSReader2
Les requêtes doivent être exécutées à partir du client. Toutes les classes clientes ont été
déclarées dans le projet CQRSFilmsClient. Dans ce TP nous vous proposons de compléter
le code des services web et des clients Java qui exploitent ces services. Cela devrait vous
permettre de bien comprendre la mécanique du pattern CQRS.
