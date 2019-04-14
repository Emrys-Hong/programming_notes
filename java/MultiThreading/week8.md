### Phaser

act as countDownLatch:
```java
Phaser phaser = new Phaser(1);
phaser.arrive(); // same as latch.CountDown(), this is called when a code have finished running
phaser.awaitAdvance(phaser.getPhase()); // same as latch.await(), this is called for the code below it to run under some condition.
```

act as CyclicBarrier
```java
phaser.arriveAndAwaitAdvance(); // equals to await()
phaser.arriveAndDeregister(); // functions as when the condition comes, the phaser would let all the threads pass.
```

Phase Functions

- `resgister()`- Adds a new unarrived party to this phaser. It returns the arrival phase number to which this registration applied.
- `arrive()`- Arrives at this phaser, without waiting for others to arrive. Note that arrive() method does not suspend execution of the calling thread. Returns the arrival phase number, or a negative value if terminated. Note that this method should not be called by an unregistered party.
- `arriveAndDeregister()`- Arrives at this phaser and deregisters from it without waiting for others to arrive. Returns the arrival phase number, or a negative value if terminated.
- `arriveAndAwaitAdvance()`- This method awaits other threads to arrives at this phaser. Returns the arrival phase number, or the (negative) current phase if terminated. If you want to wait for all the other registered parties to complete a given phase then use this method.

Phase state monitoring
- `getRegisteredParties()` - Returns the number of parties registered at this phaser.
- `getArrivedParties()` - Returns the number of registered parties that have arrived at the current phase of this phaser.
- `getUnarrivedParties()` - Returns the number of registered parties that have not yet arrived at the current phase of this phaser.
- `getPhase()` - Returns the current phase number.
- `isTerminated` - Returns true if all the parties are deregistered from the phase