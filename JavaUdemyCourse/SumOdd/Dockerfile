#first docker try
FROM openjdk:19

# create a new app directory
RUN mkdir /app

# copy the jar file to the app directory
COPY out/production/SumOdd/ /app

# set directory fo furute commands
WORKDIR /app

# run the Main class
CMD java Main

# Error: LinkageError occurred while loading main class Main
  #        java.lang.UnsupportedClassVersionError: Main has been compiled by a more recent version
  #        of the Java Runtime (class file version 63.0), this version of the Java Runtime only recognizes
  #        class file versions up to 62.0
#ERROR SOLVED:
  #this is cause the version of java used to compile the code is different from the version of java used to build the container
  #questo perché la versione di compilazione di java deve essere necessariamente uguale a quella di build del container