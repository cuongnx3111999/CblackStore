import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.cblackstore.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val nameTextView = view.findViewById<TextView>(R.id.profile_name)
        val emailTextView = view.findViewById<TextView>(R.id.profile_email)

        // Lấy thông tin người dùng từ Firestore
        val userId = auth.currentUser?.uid
        if (userId != null) {
            db.collection("users").document(userId).get().addOnSuccessListener { document ->
                if (document != null) {
                    nameTextView.text = "Name: ${document.getString("name")}"
                    emailTextView.text = "Email: ${document.getString("email")}"
                }
            }
        }

        return view
    }
}
