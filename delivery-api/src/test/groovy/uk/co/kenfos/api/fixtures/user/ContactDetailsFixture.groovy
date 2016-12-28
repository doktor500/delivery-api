package uk.co.kenfos.api.fixtures.user

import uk.co.kenfos.api.user.model.ContactDetails

class ContactDetailsFixture {

    static ContactDetails validSample() {
        new ContactDetails(
            phoneNumber: '0775 999 888',
            postcode: 'N1 AAA',
        )
    }
}
