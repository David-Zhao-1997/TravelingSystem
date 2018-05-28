package beans;

import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Remark
{
    private int remarkId;
    private String email;
    private int noteId;
    private int type;

    @Id
    @Column(name = "RemarkID", nullable = false)
    public int getRemarkId()
    {
        return remarkId;
    }

    public void setRemarkId(int remarkId)
    {
        this.remarkId = remarkId;
    }

    @Basic
    @Column(name = "Email", nullable = false, length = 100)
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Basic
    @Column(name = "NoteID", nullable = false)
    public int getNoteId()
    {
        return noteId;
    }

    public void setNoteId(int noteId)
    {
        this.noteId = noteId;
    }

    @Basic
    @Column(name = "Type", nullable = false)
    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Remark remark = (Remark) o;
        return remarkId == remark.remarkId &&
                noteId == remark.noteId &&
                type == remark.type &&
                Objects.equals(email, remark.email);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(remarkId, email, noteId, type);
    }

    @Override
    public String toString()
    {
        return "Remark{" +
                "remarkId=" + remarkId +
                ", email='" + email + '\'' +
                ", noteId=" + noteId +
                ", type=" + type +
                '}';
    }
}
