import org.scalatest.FreeSpec

import org.mindrot.jbcrypt.BCrypt

class CryptSpec extends FreeSpec {

  "Bcrypt passwords" - {
    "can be verified" in {
      assert(
        BCrypt.checkpw("dummyPassw0rd", "$2a$10$6CJWdXpKoP8bVTjGH8SbKOWevNQVL8MkYVlBLmqtywVi7dp/YgPXC")
      )
    }
  }
}

