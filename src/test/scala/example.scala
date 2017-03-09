import org.scalatest.FreeSpec

import org.mindrot.jbcrypt.BCrypt

object LiftUtil {

  import java.io._
  import java.security._
  import javax.crypto._
  import javax.crypto.spec._
  import org.apache.commons.codec.binary.Base64

  def hash(in: String): String =
    base64Encode(MessageDigest.getInstance("SHA").digest(in.getBytes("UTF-8")))

  def base64Encode(in: Array[Byte]): String = new String(cleanArray((new Base64).encode(in)))

  private final def cleanArray(in: Array[Byte]): Array[Byte] = in.filter(a => a >= 32 && a <= 127)
}

class CryptSpec extends FreeSpec {

  "Bcrypt passwords" - {

    "can be verified" in {
      assert(
        BCrypt.checkpw("dummyPassw0rd", "$2a$10$6CJWdXpKoP8bVTjGH8SbKOWevNQVL8MkYVlBLmqtywVi7dp/YgPXC")
      )
    }

    "lift format can be decoded" in {
      // Given
      val password = "brighton"
      val salt = "ERF15DLXI2BXFJGO"
      // Then
      val hashed = LiftUtil.hash(s"{$password} salt={$salt}")
      assert(hashed == "lTvqr9Ge8OH+tNWaghpUucXF3XU=")
    }

  }
}
