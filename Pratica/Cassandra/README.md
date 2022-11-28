
### Docker commando to create network

```

docker network create cbd-network

```


### To start a cassandra server isntance
```

  docker run --name cassandra-cbd --network cbd-network -d cassandra:latest

```

### Connecto to Cassandra from cqlsh

```

docker run -it --network cbd-network --rm cassandra cqlsh cassandra-cbd

```
