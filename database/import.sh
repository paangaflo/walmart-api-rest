#! /bin/bash

mongoimport --host api-database --db promotions --collection products --drop --type json --file /database/products.json