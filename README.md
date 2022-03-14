# Sample Calendar Booking
Time sensitive demonstration of a calendar selection for a generic booking process

## Installation

 1. Install the latest version of stable Android Studio (BumbleBee 2021.1.1 Patch 2 at time of writing)
 2. Check out this project and import into Android Studio (if not already done so)
 3. Perform a gradle sync
 4. Build App to emulator or device

## Test Requirements

 1. A device or emulator of API level 26 (Android 8.0) or greater
 2. The test medium must have internet access to load images


## Considerations

 1. This project was tackled as a proof of concept highlighting a clean architecture approach, with UI being left until last (paper mocking was performed at the start to get an idea of the data structures required by the UI)
 2. The package structure treats code outside of the data/domain/presentation packages as the "rest of the theoretical app", and everything inside as the "calendar feature".  If this were a real app, the code would either live in its own module, attain a feature package structure
 3. All times from API (json array), are considered UCT ([Instant](https://docs.oracle.com/javase/8/docs/api/java/time/Instant.html) in java)
 4. This was achieved by way of MVVM viewmodels as well MVI (with the help of [mavericks](https://github.com/airbnb/mavericks)) for its unidirectional data flow and encapsulated immutable state models.
 5. Use cases/interactors and model mappers were used to highlight layer boundaries and how one might cross them
 6. DI was performed throughout by way of the [Hilt](https://dagger.dev/hilt/) library, supported by Google.
 7. Due to time constraints, tests were only focussed on in the use case sample, with comments in code highlighting how some other areas may have been test.
 8. Theming was ignored in this process, but references as one would if correctly setup
 9. For the UX, it was assumed the user arrived on a full screen date picker based on the spec of

> they’re presented with a calendar showing

## Room for improvement

 1. highlighted in comments in app
 2. The relative time displayed on selection does not always use the same offset for all bookings, I would need to investigate further ([documentation, see withZoneSameInstant](https://docs.oracle.com/javase/8/docs/api/java/time/ZonedDateTime.html))
 3. all days are enabled on the calendar, this should come from the backend
 4. day ranges are not handled specifically by UI
 5. grouping existing bookings from same Space
 6. On larger screens, the calendar can be pulled out of the top drawer (no more show/hide affordance) and placed on the left in landscape, and top on portrait
 7. Days with booked slots could be better highlighted than the current red number
 8. Accessibility is lacking in some elements
 9. edge case testing, I came across a few while iterating
 10. fix the scaffold background, it doesn't look great when the content is pulled down
 11. and a lot more, I would enjoy a chat around what might be expected and how I could tackle it
 12. The usual setup of code checks, formatting etc has been ignored here
 13. Add Loading, Content, Error states to UI
 14. Use resources and not hardcodced strings, dimensions etc

## Final Thoughts

 1. It was an interesting challenge, especially in the way that I had to take a chance and assume the focus of the test, due to time constraints
 2. This was the first time I used the backdrop pattern, I had some learning here, which is always great, hope it paid off :)
 3. For some reason, my brain assumed 2 things, before I reread the spec a number of times. One, the user is on a Space Screen and two, the relative time upon selection was the duration between the selection and previously booked. Intentional?